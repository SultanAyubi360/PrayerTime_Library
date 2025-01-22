# PrayerTime Library

<p align="center">
  <img src="https://i.ibb.co/y0rk0Qp/950d55da-7eee-4d9d-a4a3-b588d1c0fd25.png">
</p>
</br>

**Fixed and Calculated Prayer Times**:
Most cities around the world find their prayer times by using some calculations which is based on location (longitude and latitude) but some other cities have fixed time table for their prayer times. This library contains most fixed and calculated prayer times. Now you can contribute it to improve it and also you can use it in Muslim communities or Muslim apps.Muslims have 5 prayers per day, at each time all muslims are notified by Azan, to pray. first Muslims used to calcualte prayer time with sun raise and sun shadows, but to simplyied it and make it moreaccurent speacilly in cloudy cities, Mosques currently use a complex calcualtion based on latitude, longitude, height, timezone, sun raise time.Prayer Times provides a set of handy functions to calculate prayer times for any location around the world, based on a variety of calculation methods currently used in Muslim communities.

<div align="center">

[![](https://jitpack.io/v/SultanAyubi360/PrayerTime_Library.svg)](https://jitpack.io/#SultanAyubi360/PrayerTime_Library/1.1)
![Status](https://img.shields.io/badge/Status-Active-brightgreen) ![Kotlin](https://img.shields.io/badge/Kotlin-100%25-brightgreen) ![](https://img.shields.io/badge/Platform-Android-brightgreen.svg)

</div>


## What is PrayerTime library?  
  
Library aiming to calculate prayer time with one line code , if you implement prayer time application , there is no need to do this headache again .  
  
Islam Time prayers is every complex to calculate, cause there is many variables in this calculations like:  
  
- **latitude**  
- **longitude**  
- **timezone**  
- **height**  
- **The Way of Calculation**   


PrayerTime library enables you to determin latitude, longitude, timezone, height, The Way of Calculation as Inputes. 


## ✨ Sample Videos

<kbd>

<video src="https://github.com/user-attachments/assets/fc44135b-fc86-4d71-85e2-ec3d4dc98d91" width="30" height="30" /> 

</kbd>

<kbd>

<video src="https://github.com/user-attachments/assets/36bb687a-59b8-41dc-a09a-bdcef2ed036c" width="30" height="30" />

</kbd>

## How to use ? 

### Step 1

Add this in your root build.gradle at the end of repositories
- in your `allprojects` section , you have to add  `maven { url 'https://jitpack.io' }`
  
#### In older Gradle Style (Build.gradle (project level))
```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

#### In New Project Structure (Settings.gradle)
```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ......
        maven { url 'https://jitpack.io' }
        .....
    }
}
```

### Step 2

Add the dependency in your build.gradle.

# For groovy DSL

```
dependencies {
    implementation 'com.github.SultanAyubi360:PrayerTime_Library:1.1'
}
```

# For Kotlin DSL

```
dependencies {
    implementation ("com.github.SultanAyubi360:PrayerTime_Library:1.1")
}
```
---

## Step 3

# Usage

### Create an `PrayerTime`

You will need to create a new instance of `PrayerTime`. Once the instance are configured, you can call `getPrayerTimes()`.

---

* Java
```java
 // Creating an instance of PrayTime
		PrayerTime prayers = new PrayerTime();
```

* Kotlin
```Kotlin
		 // Creating an instance of PrayTime
    val prayTime = PrayTime()
```
---

## Step 4

After creating PrayTime instance move next where we will get latitude and longitude from user.

* Java
```java
// Declaring and initializing latitude and longitude
 double latitude = 33.5953143;
 double longitude = 73.0412202;//Rawalpindi
```

* Kotlin
```Kotlin
    // Declaring and initializing latitude and longitude
    val latitude: Double = 33.5953143
    val longitude: Double = 73.0412202//Rawalpindi
```
---

## ✨ Screenshots

<kbd>
  <img src="https://i.ibb.co/BnkJSxZ/Media-1.jpg" width=30% height=30%/>
  <img src="https://i.ibb.co/n8SckX7/Media.jpg" width=30% height=30%/>
</kbd>


## Reporting an issue

If you are going to report an issue, I will greatly appreciate you including some code which I can run to see the issue. By doing so you maximize the chance that I will fix the problem. 
By the way, before reporting a problem, try replacing DiscreteScrollView with a RecyclerView. If the problem is still present, it's likely somewhere in your code.


## Find this library useful? :heart:

However, if you get some profit from this or just want to encourage me to continue creating stuff, there are few ways you can do it. :coffee: :hamburger: :fries: :apple:

Support it by joining stargazers to this. ⭐

Also, [follow me on GitHub](https://github.com/SultanAyubi360) for my next creations! 🤩

