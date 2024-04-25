package com.example.peekrv;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;

public class FadingTextView extends AppCompatTextView {

    // Length
    private static final float PERCENTAGE = .9f;
    private static final int CHARACTERS = 6;

    // Attribute for ObjectAnimator
    private static final String MAX_HEIGHT_ATTR = "maxHeight";

    private final Shader shader;
    private final Matrix matrix;
    private final Paint paint;
    private final Paint textPaint;
    private final Rect bounds;

    private int mMaxLines;
    private boolean mExpanded = false;

    private final boolean showExpandedCollapse;

    public FadingTextView(Context context) {
        this(context, null);
    }

    public FadingTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public FadingTextView(Context context, AttributeSet attrs, int defStyleAttribute) {
        super(context, attrs, defStyleAttribute);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FadingTextView);
        this.showExpandedCollapse = typedArray.getBoolean(R.styleable.FadingTextView_showExpandedCollapse, false);

        matrix = new Matrix();
        paint = new Paint();
        bounds = new Rect();
        if (showExpandedCollapse) {
            shader = new LinearGradient(0f, 0f, 0.4f, 0f, Color.TRANSPARENT, Color.BLACK, Shader.TileMode.CLAMP);
        } else {
            shader = new LinearGradient(0f, 0f, PERCENTAGE, 0f, Color.TRANSPARENT, Color.BLACK, Shader.TileMode.CLAMP);
        }
        paint.setShader(shader);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));

        textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTypeface(ResourcesCompat.getFont(context, R.font.nunito_medium));
        textPaint.setTextSize(13);

        mMaxLines = getMaxLines();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (getLineCount() > getMaxLines() && !mExpanded
                && getRootView() != null && getText() != null
        ) {

            final Matrix m = matrix;
            final Rect b = bounds;
            final Layout l = getLayout();

            final int line = mMaxLines - 1;

            getLineBounds(line, b);

            final int lineStart = l.getLineStart(line);
            final int lineEnd = l.getLineEnd(line);
            final CharSequence text = getText().subSequence(lineStart, lineEnd);
            final int measure = (int) (getPaint().measureText(text, 0, text.length()));
            final int measureText = (int) (getPaint().measureText("...more", 0, "...more".length()));

            int fadeLength;
            if (showExpandedCollapse) {
                if (measure + measureText > super.getWidth()) {
                    fadeLength = (int) (getPaint().measureText(getText(), getText().length() - CHARACTERS - 8, getText().length()));
                } else {
                    fadeLength = (int) (getPaint().measureText(getText(), getText().length() - CHARACTERS - 6, getText().length()));
                }
            } else {
                fadeLength = (int) (getPaint().measureText(getText(), getText().length() - CHARACTERS, getText().length()));
            }

            b.right = b.left + measure;

            b.left = b.right - fadeLength;
            final int saveCount = canvas.saveLayer(0, 0, getWidth(), getHeight(), null);

            super.onDraw(canvas);

            m.reset();
            m.setScale(fadeLength, 1f);
            m.postTranslate(b.left, 0f);
            shader.setLocalMatrix(matrix);
            canvas.drawRect(b, paint);

            if (showExpandedCollapse) {
                canvas.drawText("...more", b.right - measureText, b.bottom - getLineHeight() / 4f, textPaint);
            }

            canvas.restoreToCount(saveCount);

        } else {
            super.onDraw(canvas);
        }
    }

    /**
     * Makes the TextView expanding without any animation.
     */
    public void expandCollapse() {
        setMaxLines(mExpanded ? mMaxLines : getLineCount());
        mExpanded = !mExpanded;
    }

    /**
     * Makes the TextView expanding/collapsing with sliding animation (vertically)
     *
     * @param duration Duration in milliseconds from beginning to end of the animation
     */
    public void expandCollapseAnimated(final int duration) {
        // Height before the animation (either maxLine or lineCount, depending on current state)
        final int startHeight = getMeasuredHeight();

        // Set new maxLine value depending on current state
        setMaxLines(mExpanded ? mMaxLines : getLineCount());
        mExpanded = !mExpanded;

        // Measuring new height
        measure(View.MeasureSpec.makeMeasureSpec(
                        getWidth(), View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        );
        final int endHeight = getMeasuredHeight();

        ObjectAnimator animation = ObjectAnimator.ofInt(
                this,               // TextView
                MAX_HEIGHT_ATTR,    // maxHeight
                startHeight,        // height before animation
                endHeight           // height after animation
        );
        animation.setDuration(duration).start();
    }

    /**
     * Sets maxLine value programmatically
     *
     * @param newValue new value for maxLines
     */
    public void setNewMaxLine(int newValue) {
        mMaxLines = newValue;
    }
}
