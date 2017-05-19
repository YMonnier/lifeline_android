# Lifeline UI

Lifeline UI Component for Android

![Alt text](./Resources/Screenshot_1.png?raw=true "Title")

## Installation

I do not have the time to create a Gradle dependency. So you can easily copy the `LifelineView.java` and attributes to your project.

1. Copy `LifelineView.java`
2. Define a custom attributes

Copy the `declare-styleable` into your `res/values/attrs.xml`.

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <declare-styleable name="LifelineView">
        <attr name="steps" format="integer" />
        <attr name="selected" format="integer" />
        <attr name="stepRadius" format="dimension" />
        <attr name="lineColor" format="color" />
        <attr name="stepDefaultColor" format="color" />
        <attr name="stepSelectedColor" format="color" />
        <attr name="lineThickness" format="integer" />
    </declare-styleable>
</resources>
```

## How to use it?

```xml
<LifelineView
        android:layout_width="match_parent"
        android:layout_height="100dp"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:id="@+id/lifelineView"
        app:stepRadius="15dp"
        app:steps="4"
        app:stepDefaultColor="@color/gray"
        app:stepSelectedColor="@color/orange_dark"
        app:lineColor="@color/orange"
        app:lineThickness="6" />
```

```java
public class MyFragment extends Fragment {

    LifelineView lifelineView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lifelineView = (LifelineView) findViewById(R.id.lifelineView);
        lifelineView.setSelected(2);
    }

    @AfterViews
    void init() {

    }
}
```

API
---

| Attribute         |                       |
|-------------------|-----------------------|
| `steps`            | number of circles     |
| `stepRadius`        | circle radius         |
| `stepDefaultColor`  | default circle color  |
| `stepSelectedColor` | selected circle color |
| `selected`          | selection rank        |
| `lineColor`         | line color            |
| `lineThickness`     | line thickness        |


Contributor
------------

* [@YMonnier](https://github.com/YMonnier)


License
-------
lifeline_android is available under the MIT license. See the [LICENSE](https://github.com/YMonnier/lifeline_android/blob/master/LICENSE) file for more info.
