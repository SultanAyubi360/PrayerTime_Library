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

## How to implement and use methods:

You will need to create a new instance of `PrayerTime`. Once the PrayerTimes object has been initialized pass Calculation Parameters in `getPrayerTimes()` method which take 4 arguments current date,latitude longitude and timezone.Once the instance are configured, you can call `getPrayerTimes()`.

## Full implementation

* Java
```java
 
        // create a new instance of `PrayerTime`
        PrayTime prayers = new PrayTime();

        // Getting the system timezone from the device
        double timezone = prayers.getBaseTimeZone(); 

        // Setting the time format to 12-hour format
        prayers.setTimeFormat(prayers.Time12);

        // Setting the calculation method to Karachi
        prayers.setCalcMethod(prayers.Karachi);

        // Setting the juristic method for Asr to Hanafi
        prayers.setAsrJuristic(prayers.Hanafi);

         // Adjusting for high latitudes
        prayers.setAdjustHighLats(prayers.AngleBased);

        // Get the current date
        Calendar cal = Calendar.getInstance();

       // Give latitude and longitude now i give hardcoded which will be change with current location of user after getting location permission.
        double latitude = 33.5953143;
        double longitude = 73.0412202;

        // Get prayer times
        ArrayList<String> prayerTimes = prayers.getPrayerTimes(cal, latitude, longitude, timezone);

       // Get prayer names
        ArrayList<String> prayerNames = prayers.getTimeNames();
```

* Kotlin
```Kotlin

    //create a new instance of `PrayerTime`
    val prayers = PrayTime()

    // Getting the system timezone from the device
    val timezone: Double = prayers.getBaseTimeZone()

    // Setting the time format to 12-hour format
    prayers.setTimeFormat(prayers.Time12)

    // Setting the calculation method to Karachi
    prayers.setCalcMethod(prayers.Karachi)

    // Setting the juristic method for Asr to Hanafi
    prayers.setAsrJuristic(prayers.Hanafi)

    // Adjusting for high latitudes
    prayers.setAdjustHighLats(prayers.AngleBased)

    // Get the current date
    val cal: Calendar = Calendar.getInstance()

    // Give latitude and longitude now i give hardcoded which will be change with current location of user after getting location permission.
    val latitude = 33.5953143
    val longitude = 73.0412202

    // Get prayer times
    val prayerTimes: ArrayList<String> = prayers.getPrayerTimes(cal, latitude, longitude, timezone)

    // Get prayer names
    val prayerNames: ArrayList<String> = prayers.getTimeNames()
```
---

## Step 4

## Prayer Times

Once the `PrayerTimes` object has been initialized it will contain values for all five prayer times and the time for sunrise. To display these Prayer times and Prayer names you can use both ArrayLists we have  'prayerTimes' and 'prayerNames'. Now i am using these to set data in adapter and show in recyclerview see below.You guys can create recyclerview and adapter according to your requirements, Here just I give you idea how to pass list to adapter and show records in recyclerview.

* Java
```java

prayerModelList = new ArrayList<>();
        for (int i = 0; i < prayerTimes.size(); i++) {
            String imageUrl;
            switch (prayerNames.get(i).toLowerCase()) {
                case "fajr":
                    imageUrl = FAJR_URL;//image urls to set in imageview in recyclerview item pass "https://i.ibb.co/qdm2t9M/Fajr-Prayer-English.png" like this also.
                    break;
                case "sunrise":
                    imageUrl = SUNRISE_URL;
                    break;
                case "zuhar":
                    imageUrl = DHUHR_URL;
                    break;
                case "asar":
                    imageUrl = ASR_URL;
                    break;
                case "sunset":
                    imageUrl = SUNSET_URL;
                    break;
                case "maghrib":
                    imageUrl = MAGHRIB_URL;
                    break;
                case "isha":
                    imageUrl = ISHA_URL;
                    break;
                default:
                    imageUrl = "";
                    break;
            }
            prayerModelList.add(new PrayerModel(imageUrl, prayerNames.get(i), prayerTimes.get(i)));
        }

        // Set up the RecyclerView
        prayerAdapter = new PrayerAdapter(prayerModelList, this);
        live_rv.setLayoutManager(new LinearLayoutManager(this));
        live_rv.setAdapter(prayerAdapter);
```

* Kotlin
```Kotlin

val prayerModelList = ArrayList<PrayerModel>()

for (i in prayerTimes.indices) {
    val imageUrl: String = when (prayerNames[i].toLowerCase()) {
        "fajr" -> FAJR_URL //image urls to set in imageview in recyclerview item pass "https://i.ibb.co/qdm2t9M/Fajr-Prayer-English.png" like this also.
        "sunrise" -> SUNRISE_URL
        "zuhar" -> DHUHR_URL
        "asar" -> ASR_URL
        "sunset" -> SUNSET_URL
        "maghrib" -> MAGHRIB_URL
        "isha" -> ISHA_URL
        else -> ""
    }

    prayerModelList.add(PrayerModel(imageUrl, prayerNames[i], prayerTimes[i]))
}

// Set up the RecyclerView
val prayerAdapter = PrayerAdapter(prayerModelList, this)
live_rv.layoutManager = LinearLayoutManager(this)
live_rv.adapter = prayerAdapter

```
---

## ✨ Screenshots

<table>
  <tr>
    <td><b>Media 1:</b><br>
        <img src="https://i.ibb.co/BnkJSxZ/Media-1.jpg" width="300"/>
    </td>
    <td><b>Media 2:</b><br>
        <img src="https://i.ibb.co/n8SckX7/Media.jpg" width="300"/>
    </td>
  </tr>
</table>

#### Calculation parameters

The rest of the needed information is contained within the `CalculationParameters`.It is recommended to use one of the pre-populated instances in the `CalculationMethod` class. You can then further customize the calculation parameters if needed.


| Parameter | Description |
| --------- | ----------- |
| `TimeFormat`| Time Format 12-hour format or other|
| `method`    | CalculationMethod name |
| `AsrJuristic`| Juristic method for Asr |
| `fajrAngle` | Angle of the sun used to calculate Fajr |
| `ishaAngle` | Angle of the sun used to calculate Isha |
| `ishaInterval` | Minutes after Maghrib (if set, the time for Isha will be Maghrib plus ishaInterval) |
| `madhab` | Value from the Madhab object, used to calculate Asr |
| `highLatitudeRule` | Value from the HighLatitudeRule object, used to set a minimum time for Fajr and a max time for Isha |
| `adjustments` | JavaScript object with custom prayer time adjustments in minutes for each prayer time |

**TimeFormat**

| Value | Description |
| ----- | ----------- |
| `Time24` | 24-hour format |
| `Time12` | 12-hour format |
| `Time12NS` |12-hour format with no suffix |
| `Floating` |floating point number |


**CalculationMethod**

| Value | Description |
| ----- | ----------- |
| `MUSLIM_WORLD_LEAGUE` | Muslim World League. Fajr angle: 18, Isha angle: 17 |
| `EGYPTIAN` | Egyptian General Authority of Survey. Fajr angle: 19.5, Isha angle: 17.5 |
| `KARACHI` | University of Islamic Sciences, Karachi. Fajr angle: 18, Isha angle: 18 |
| `UMM_AL_QURA` | Umm al-Qura University, Makkah. Fajr angle: 18, Isha interval: 90. *Note: you should add a +30 minute custom adjustment for Isha during Ramadan.* |
| `NORTH_AMERICA` | Referred to as the ISNA method. This method is included for completeness but is not recommended. Fajr angle: 15, Isha angle: 15 |
| `TEHRAN` | Institute of Geophysics, University of Tehran. Fajr angle: 17.7, Isha angle: 14 |
| `JAFARIA` | Ithna Ashari Fajr angle: 16, Isha angle: 14 |
| `Custom` | Custom Setting |

**Madhab**

| Value | Description |
| ----- | ----------- |
| `SHAFI` | Earlier Asr time |
| `HANAFI` | Later Asr time |

**HighLatitudeRule**

| Value | Description |
| ----- | ----------- |
| `MIDDLE_OF_THE_NIGHT` | Fajr will never be earlier than the middle of the night and Isha will never be later than the middle of the night |
| `SEVENTH_OF_THE_NIGHT` | Fajr will never be earlier than the beginning of the last seventh of the night and Isha will never be later than the end of the first seventh of the night |
| `ANGLEBASED` | Similar to `SEVENTH_OF_THE_NIGHT`, but instead of 1/7, the fraction of the night used is fajrAngle/60 and ishaAngle/60 |
| `NONE` | No adjustment |

### Configurations
* `setTimeFormat` To change the time format to:
	* `Time24`  24-hour format
	* `Time12`  12-hour format
	* `Time12NS`  12-hour format with no suffix
	* `Floating`  floating point number
* Java
```java
prayers.setTimeFormat(prayers.Time12);
```
* Kotlin
```Kotlin
prayers.setTimeFormat(prayers.Time12)
```

* `setCalcMethod` To change the Calculation Methods.
	* `Karachi`  University of Islamic Sciences, Karachi
	* `ISNA`  Islamic Society of North America (ISNA)
	* `MWL`  Muslim World League (MWL)
	* `Makkah`  Umm al-Qura, Makkah
	* `Egypt`  Egyptian General Authority of Survey
	* `Jafari`  Ithna Ashari
	* `Tehran`  Institute of Geophysics, University of Tehran
	* `Custom`  Custom Setting
* Java
```java
 prayers.setCalcMethod(prayers.Karachi);
```
* Kotlin
```Kotlin
prayers.setCalcMethod(prayers.Karachi)
```

* `setAsrJuristic` To change Juristic Method for Asr
	* `Shafii`  Shafii (standard)
	* `Hanafi`  Hanafi
* Java
```java
 prayers.setAsrJuristic(prayers.Hanafi);
```
* Kotlin
```Kotlin
prayers.setAsrJuristic(prayers.Hanafi)
```

* `setAdjustHighLats` Adjusting Methods for Higher Latitudes
	* `None`  No adjustment
	* `MidNight`  middle of night
	* `OneSeventh`  1/7th of night
	* `AngleBased`  angle/60th of night
* Java
```java
 prayers.setAdjustHighLats(prayers.AngleBased);
```
* Kotlin
```Kotlin
prayers.setAdjustHighLats(prayers.AngleBased)
```

## Reporting an issue

If you are going to report an issue, I will greatly appreciate you including some code which I can run to see the issue. By doing so you maximize the chance that I will fix the problem. 
By the way, before reporting a problem, try replacing DiscreteScrollView with a RecyclerView. If the problem is still present, it's likely somewhere in your code.


## Find this library useful? :heart:

However, if you get some profit from this or just want to encourage me to continue creating stuff, there are few ways you can do it. :coffee: :hamburger: :fries: :apple:

Support it by joining stargazers to this. ⭐

Also, [follow me on GitHub](https://github.com/SultanAyubi360) for my next creations! 🤩

