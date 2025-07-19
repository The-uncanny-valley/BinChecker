# BinChecker

**BinChecker** is a simple Android application that allows users to look up the details of a Bank Identification Number (BIN) using the public [Binlist API](https://binlist.net/). The application also keeps a local history of previous queries.
This project was created as a test assignment for an Android Developer internship at **ООО "Экосистема Альфа"**.

## Planned Features

* Search BIN information using [https://binlist.net](https://binlist.net)
* Display details such as card scheme, type, brand, country, and bank info
* Save and view query history locally
* Tap to copy or open external links (like location or bank website)
* Clean and responsive UI with input validation and error handling

## Tech Stack

* **Language**: Kotlin
* **Architecture**: MVVM, Clean Architecture principles
* **UI**: XML
* **Concurrency**: Kotlin Coroutines
* **Dependency Injection**: Hilt
* **Networking**: Retrofit
* **Persistence**: Room
* **Navigation**: Jetpack Navigation Component

## Screenshots

| BIN Lookup Screen                 | History Screen                      |
| --------------------------------- | ----------------------------------- |
| ![Lookup](screenshots/lookup.png) | ![History](screenshots/history.png) |

> *Note: Please replace the image paths above with actual screenshots or remove this section if not applicable.*

## 🔧 Setup Instructions

1. Clone the repository:

   ```
   git clone https://github.com/The-uncanny-valley/BinChecker.git
   ```
2. Open the project in **Android Studio (Arctic Fox or newer)**
3. Let Gradle sync and build the project
4. Run the app on an emulator or physical device with Android 6.0+

> API is public and requires no authentication.

## Project Structure

```
com.example.binchecker
├── data        // Room DB, Retrofit API, DTOs, mappers
├── domain      // Use cases, models, repositories
├── presentation// ViewModels, Activities, Fragments
├── di          // Hilt modules
```

## Usage

1. Enter the first 6-8 digits of a card (BIN)
2. Press **Search**
3. View the card’s issuing country, scheme, type, bank contact, etc.
4. Tap on:
   * **Bank phone** to copy to clipboard
   * **Website** to open in browser
   * **Country** to view location in maps
5. Visit the **History** tab to see previous searches

## Limitations

* Only the layout for the search screen has been implemented so far.
* No actual search functionality is wired to the API yet.
* BIN data is not retrieved or displayed.
* No history screen or local data storage is available yet.
* Navigation between screens is not yet implemented.
* Error handling, loading states, and input validation are pending.
* No pagination or advanced caching for now
* History cannot be cleared

## License

This project is under the MIT License — see the [LICENSE](LICENSE) file for details.
