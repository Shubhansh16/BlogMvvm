# BlogMvvm

The Blog Reader App is an Android application built using Jetpack Compose that allows users to browse and read blog posts fetched from an online API. The app implements pagination, offline support with Room database, and a shimmer loading effect for a smooth and user-friendly experience.

Display Blogs in a List

Uses Jetpack Compose's LazyColumn to display paginated blog posts
Includes a shimmer effect while loading content
Read Blog Posts in WebView

Clicking on a blog opens its content in WebView
Implements a back button handler for WebView navigation
Offline Support

Caches blog posts using Room Database
Fetches data from the local database when offline
MVVM Architecture

Implements Repository pattern for data management
Uses ViewModel for UI-related data handling

Tech Stack
UI Framework: Jetpack Compose
Networking: Retrofit + Gson
Pagination: Paging 3
Local Storage: Room Database
Dependency Injection: ViewModelProvider.Factory
Offline Handling: Room caching
Navigation & Back Handling: Compose navigation + BackHandler
UI Enhancements: Shimmer loading effect (Accompanist)
