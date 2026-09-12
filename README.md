# S8173367 Assignment 2

An Android application built within Android Studio. Users log in against a remote API, view a dashboard of items fetched from the server, and tap into a details screen for each item.


## Prerequisites

1. **Android Studio** - Download from https://developer.android.com/studio.
2. **JDK 11 or newer** - Android Studio bundles its own JDK, so you typically don't need to install this separately unless you plan to run Gradle from a standalone terminal outside the IDE.
3. **GitHub Desktop + account** - with access to this repository.
4. **Internet connection** - the app calls a live remote API https://nit3213apinew.onrender.com/, and Gradle needs to download dependencies on first build.

## 1. Get the repository using GitHub Desktop

1. If you don't already have it, download and install **GitHub Desktop** from https://desktop.github.com/.
2. Open GitHub Desktop and sign in with your GitHub account if prompted.
3. Go to the repository's page https://github.com/WILLIAM-THI/s8173367Assignment2 in your browser.
4. Click the green **Code** button, then select **Open with GitHub Desktop**.
5. GitHub Desktop will open and show a **Clone a Repository** dialog. Choose a **Local Path** on your computer (e.g. Desktop or Documents), then click **Clone**.

Once cloning finishes, you'll have a regular folder on your computer containing the project files, ready to open in Android Studio.


## 2. Open the project in Android Studio

1. Launch Android Studio.
2. On the Welcome screen, choose **Open**.
3. Navigate to the folder you just cloned and select it, then click **OK**.
4. Android Studio will begin indexing the project. Let this finish before continuing.


## 3. Let Gradle sync and download dependencies

The first time you open the project, Android Studio will automatically start a **Gradle Sync**. This step downloads every dependency the app needs.

If the sync doesn't start automatically, click the **"Sync Now"** banner that appears at the top of the editor, or go to **File, Sync Project with Gradle Files**.


## 4. Install the required Android SDK platform

This app targets **SDK 37**. Android Studio should prompt you to install any missing SDK platform automatically 


## 5. Run the app on an emulator

1. Open **Tools, Device Manager**.
2. Click **Create Device**.
3. Choose a device profile (e.g. Pixel 10 Pro XL) and click **Next**.
4. Select a system image matching **API 27 or higher** and download it if prompted.
5. Click **Finish** to create the virtual device.
6. In the top toolbar, select your new virtual device from the device dropdown.
7. Click the green **Run** button to build and launch the app on the emulator.


## 6. Run the app on a physical Android phone

1. **Enable Developer Options on your phone:**
   - Go to **Settings, About phone**.
   - Tap **Build number** seven times until you see "You are now a developer."
2. **Enable USB Debugging:**
   - Go to **Settings, System, Developer options**.
   - Toggle on **USB debugging**.
3. **Connect your phone to your computer** via USB cable.
4. If prompted on your phone with an "Allow USB debugging?" dialog, tap **Allow**.
5. In Android Studio's device dropdown (top toolbar), your phone should now appear as an available device. If it doesn't show up, try a different USB cable/port, or ensure your phone's driver is installed.
6. Click the green **Run** button to build and install the app directly onto your phone.


## 7. Running the unit tests

The project includes unit tests for the ViewModel, repository, adapter, and data model logic.

**From Android Studio:** right-click the `app/src/test` folder **Run 'Tests in test'**, or right-click any individual test file/function to run just that one.


## Troubleshooting

**Network calls fail on the emulator only:** confirm the emulator has internet access (check the Wi-Fi icon in the emulator's status bar) and that your firewall isn't blocking the emulator's network traffic. Restarted the phone by sliding the control bar down from the top, click the power power button then click restart.
