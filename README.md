# Vatsim Member API

**Just keep in mind this is my first public API. This was orgnially made for private use. I highly encourge people to make improvements and share them so everyone can benifit.**

Vatsim Member API is a simple Java API that allows you to...

  - Get client online time
  - Get region, and current division
  - and more.

### Wiki

I've added some examples, and other information about this API in [Wiki](https://github.com/JordannDev/VatsimMemberAPI/wiki). 

### Use

Before asking questions, **please** check out the tests, and examples.

You can either download the SRC (*which I've provided*) or download the JAR on the releases
page. I haven't setup a Maven source for it yet, but I intend on doing so.

### Examples

Getting a Members Controller Rating
```java
public static void main(String[] args){
    VatsimAPI api = new VatsimAPI();
    System.out.println(api.getInstance().createClient("1429747").getControllerRating());
}
```

Getting a Members Pilot Rating
```java
public static void main(String[] args){
    VatsimAPI api = new VatsimAPI();
    System.out.println(api.getInstance().createClient("1429747").getPilotRating());
}
```

Getting a Members name
```java
public static void main(String[] args){
    VatsimAPI api = new VatsimAPI();
    System.out.println(api.getInstance().createClient("1429747").getPilotRating());
}
```

*Check out the Wiki for more examples.*

### License

*All I ask is if you make improvements, you share them. Keeping you're improvements, etc to youreself doesn't help everyone else.*

**License is GNU General Public License v3.0**
