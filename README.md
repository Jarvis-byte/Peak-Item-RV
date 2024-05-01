# RecyclerView Peek Cards

This repository contains a solution to enhance the horizontal scrolling experience in Android applications using RecyclerView with PagerSnapHelper. The primary focus is to modify the RecyclerView setup so that it behaves similarly to a ViewPager, where users can see parts of the next and previous cards. This visual cue indicates more content is available and encourages intuitive swiping.

## Overview

The RecyclerView in this repository is designed to display, 5-item in a vertical layout, in a horizontal Recycler View while allowing a small peek of the edges of adjacent cards. This peek effect helps users understand that they can swipe horizontally to view other cards, improving user interaction and engagement.

<img src="https://github.com/Jarvis-byte/Peek-RecyclerView-with-PagerSnapHelper/blob/main/WhatsApp%20Image%202024-04-30%20at%2012.01.00%20PM%20(1).jpeg" alt="Preview Image" title="Peek Effect Preview" style="width: 400px;">


## Features

- **Custom RecyclerView Adapter**: Implements a tailored adapter to manage the Vertical Layout efficiently.
- **PagerSnapHelper Integration**: Utilizes PagerSnapHelper to ensure that each card snaps into place, mimicking the behaviour of a ViewPager.
- **Edge Peek Implementation**: Adjusts item margins and RecyclerView padding to reveal the edges of adjacent cards, providing a hint to the user that there is more content to scroll through.

## Usage

To integrate this custom RecyclerView setup into your project:
1. Clone this repository.
2. Copy the relevant code into your project.
3. Customize the dimensions and appearance of the layout as per your design requirements.

## Contributing

Contributions to improve this implementation or extend its functionality are welcome. Please feel free to fork the repository, make your changes, and submit a pull request.

## License

This project is released under the MIT License. See the [LICENSE](LICENSE.md) file for more details.

Enjoy a more intuitive horizontal scrolling experience with RecyclerView Peek Cards!
