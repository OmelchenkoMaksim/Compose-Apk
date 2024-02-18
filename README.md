# Clean Architecture Compose App

This project is a demonstration of Clean Architecture principles applied in an Android application, featuring three distinct screens, each
designed to showcase different UI and functional capabilities. The application is built entirely with Kotlin and utilizes Jetpack Compose
for UI development, offering a modern approach to Android development without any XML layouts.

## Screens

- **ExcelLikeGridScreen**: The first screen presents a dynamic grid that supports both horizontal and vertical scrolling, resembling the
  functionality of an Excel sheet. This screen demonstrates the capability to handle complex UI layouts and user interactions within a
  grid-like structure.

- **NestedListsScreen**: The second screen showcases lists within lists, where each list contains its own scrollable content. This screen is
  designed to illustrate the handling of nested scrollable elements in Jetpack Compose, providing insights into building complex
  hierarchical UI structures.

- **RickAndMortyScreen**: The third screen displays a list of characters fetched from the open Rick and Morty API. It exemplifies how to
  integrate external API data into a Compose UI, presenting the characters in a user-friendly list.

## Architecture and Modules

The project adheres to Clean Architecture principles, organized into the following modules:

- **app**: Contains the `Application` class along with other global settings. This module serves as the entry point of the application,
  integrating various components and dependencies.

- **domain**: Intended for entities, repository interfaces, and Use Cases (To be further developed in the future.). This module encapsulates
  the business logic of the application, abstracting core functionalities from external influences.

- **data**: Implements repositories and data sources. The data layer is responsible for managing data transactions, including fetching data
  from APIs or databases.

- **presentation**: Comprises screens, UI components, and ViewModels. This module focuses on the presentation layer, leveraging Jetpack
  Compose for building the UI and handling user interactions.

## Key Technologies

- **Jetpack Compose**: Used for all UI development, eliminating the need for XML layouts
  and offering a declarative approach to UI construction.

- **Ktor and Kotlin Serialization**: Utilized for network operations and data serialization, respectively,
  facilitating communication with external APIs like the Rick and Morty API.

- **ViewModels and Compose Navigation**: Employed for managing UI-related data and navigation between different screens within the app.

- **Unit Testing with JUnit 4**: The data layer includes unit tests to ensure the reliability and correctness of data operations.

- **Kotlin DSL (.kts)**: All build configuration files are written in Kotlin DSL, enhancing readability and maintainability of
  build scripts.

- **Hilt and KSP**: Used for dependency injection and Kotlin Symbol Processing,
  streamlining the setup of dependencies and code generation tasks.

## Conclusion

This project showcases the application of Clean Architecture in an Android app using Jetpack Compose, combined with modern development
practices and tools. It serves as a practical example for developers looking to explore advanced UI patterns, Clean Architecture, and the
latest Kotlin features in their applications.
