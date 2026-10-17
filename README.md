# UOL Transport Desk

Lab task for Mobile Application Development (CS02310) - Implicit Intents
Syed Zaman Abbas Naqvi | 70145163 | Section T

This is a small Android app in Java for the UOL Transport Office. It has two screens.

**Home screen (MainActivity)**
- Transport Page - opens uol.edu.pk in the browser
- Call Transport Office - opens the dialer with 04298765432
- Show Bus Stop - opens Thokar Niaz Baig in Google Maps
- Report a Problem - checks that a name is entered and then opens the second screen

All the implicit intents go through one helper method `openIntent()` which shows a toast if no app is found.

**Problem screen (ProblemActivity)**
- Shows "Hello, name! Tell us what went wrong."
- Call Driver - number must be 11 digits and start with 03
- Send Email - email is checked with Patterns.EMAIL_ADDRESS

To run it just open the project in Android Studio and press Run.
