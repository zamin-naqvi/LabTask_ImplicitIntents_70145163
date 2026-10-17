# UOL Transport Desk — Lab Task: Implicit Intents

Mobile Application Development (CS02310) · Section T · SAP ID 70145163

A small Android app (Java) for the UOL Transport Office.

## Scenario 1 — Home screen (`MainActivity`)
- University logo, name field (`etName`) and four buttons.
- **Transport Page** → opens https://www.uol.edu.pk (`ACTION_VIEW`)
- **Call Transport Office** → opens the dialer with 04298765432 (`ACTION_DIAL`)
- **Show Bus Stop** → shows Thokar Niaz Baig in maps (`ACTION_VIEW`, `geo:` Uri)
- Helper `openIntent(Context, Intent)` uses try–catch and shows "No app found for this action".

## Scenario 2 — Problem screen (`ProblemActivity`)
- **Report a Problem** checks the name, then opens `ProblemActivity` with an explicit Intent (`KEY_NAME` extra).
- Greets the student: "Hello, &lt;name&gt;! Tell us what went wrong." ("Student" if no name).
- **Call Driver** → accepts only 11 digits starting with 03, then opens the dialer.
- **Send Email** → checks `Patterns.EMAIL_ADDRESS`, then opens an email app (`ACTION_SENDTO`).

## How to run
Open the project in Android Studio, sync Gradle and run on an emulator or device.
