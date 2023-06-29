# SampleNewsArticle
SampleNewsArticle project created with Android jetpack compse
# Code Compilation Instructions:
 •	IDE/Plugin Versions: The code is expected to be compiled and run using an Android development environment such as Android Studio. The recommended version is the latest stable release Flamingo.
•	Dependency Management: The code uses Gradle and java for dependency management. The required dependencies should be resolved automatically by the build system when the project is imported into Android Studio.
# Architecture and Logical Modules:
•	The project follows the MVVM (Model-View-ViewModel) architecture pattern along witch clean architecture principles
The MVVM architectural pattern separates the concerns of the application into three main components:
Model: The data.model package contains the data models used in the application. These models represent the structure and properties of the news articles and related assets.
View: The UI screens and components are located in the ui.screens package. These screens are responsible for displaying the news articles and handling user interactions. The NewsArticleListScreen composable function, for example, is the View component that displays a list of news articles.
ViewModel: The presentation.viewmodel package contains the ViewModel class, NewsArticleViewModel. This class acts as a bridge between the View and the data models. It holds the data required by the View and exposes it through observable properties. The ViewModel also contains the business logic for loading the news articles and managing the state of the data. It communicates with the repository to fetch the news articles and updates the state accordingly.
# Logical Modules:
•	data.model: Contains the data models used in the application.
•	repository: Contains the repository class responsible for fetching news articles from a remote data source.
•	presentation.viewmodel: Contains the ViewModel class that holds the data and business logic for the UI.
•	services: Contains the service interface for making network requests.
•	ui.navigation: Contains the navigation logic for the app using Jetpack Navigation.
•	ui.screens: Contains the UI screens and components for displaying news articles.
# 3rd Party Libraries:
•	Retrofit: Used for making HTTP requests and handling network communication.
•	Timber: Used for logging and debugging purposes.
•	Dagger is a dependency injection framework that simplifies the process of managing dependencies and their injections into objects. It helps in decoupling dependencies, improving testability, and promoting modular and scalable application design.here Dagger is used specifically with Dagger Hilt, which is an opinionated extension of Dagger for Android development. Dagger Hilt provides annotations and additional features that make it easier to integrate Dagger into Android projects.
# Additional Features:
  The project includes the following features:
•	Loading and displaying a list of news articles.
•	Navigation between the welcome screen and the news articles screen.
•	Opening news articles in a web view for detailed reading.
# Tests
NewsArticlesTest:
testGetSortedListOfAssets(): Verifies the correctness of the getSortedListOfAssets() function in the NewsArticles class. Compares the expected sorted list of assets with the actual sorted list obtained from the function.
AssetTest:
testGetSmallestImageUrl(): Validates the correctness of the getSmallestImageUrl() function in the Asset class. Compares the expected smallest image URL with the actual smallest image URL returned by the function.



