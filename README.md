<h1 align="center">Shopping Movies</h1>
<p align="center">
</p>
<h2 align="center">Screenshots</h2>
<img src="Screenshot_20190512-194427_Shopping Movies.jpg" vspace="5" align= "left" width=275 >
<img src="Screenshot_20190512-194500_Shopping Movies.jpg" vspace="5" align= "left" width=275 >
<img src="Screenshot_20190512-194512_Shopping Movies.jpg" vspace="5" width=275>
<img src="Screenshot_20190512-194523_Shopping Movies.jpg" vspace="5" width=275>

## Features
*   Discover the most popular and the most rated movies
*   User can view and play trailers on youtube 
*   Shows a list of reviews for each movie
*   Users can mark a movie for Shopping car in the details view by tapping a Shopping car icon 
*   Users can share movie trailers with their network
*   Offline support: app makes use of `NetworkBoundResource`, which uses database as the single source of truth
*   Advanced uses of Room
*   MVVM with Android Architecture Components(Room, LiveData, ViewModel)
*   Pagination and endless scrolling using Android paging library.
*   Handle network status and network failures
*   ConstraintLayout(guidelines, barriers... etc)
*   Material design.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
*   Android Studio 3.4 stable
*   Java JDK

### Installing
Follow these steps if you want to get a local copy of the project on your machine.

#### 1. Clone or fork the repository by running the command below	
```
https://github.com/juanchosandox90/ShoppingMovies.git
```

#### 2. Import the project in AndroidStudio, and add API Key
1.  In Android Studio, go to File -> New -> Import project
2.  Follow the dialog wizard to choose the folder where you cloned the project and click on open.
3.  Android Studio imports the projects and builds it for you.
4.  Add TheMovieDb API Key inside `gradle.properties` file.

```
TMDB_API_KEY="40621375c286f2119d3fe5ae0ff380b8"
```

## Libraries
*   [AndroidX](https://developer.android.com/jetpack/androidx/) - Previously known as 'Android support Library'
*   [Glide](https://github.com/bumptech/glide) - for loading and caching images 
*   [Retrofit 2](https://github.com/square/retrofit) - Type-safe HTTP client for Android and Java by Square, Inc. 
*   [Gson](https://github.com/google/gson) - for serialization/deserialization Java Objects into JSON and back
*   [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
*   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
*   [Paging](https://developer.android.com/topic/libraries/architecture/paging/)
*   [DataBinding](https://developer.android.com/topic/libraries/data-binding/)
*   [OkHttp](https://github.com/square/okhttp)
*   [Timber](https://github.com/JakeWharton/timber)
*   [CircleImageView](https://github.com/hdodenhof/CircleImageView)
*   [TextDrawable](https://github.com/amulyakhare/TextDrawable)
