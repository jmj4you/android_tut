
#These lines should be noted

Menu Layout:
menu/menu_main.xml

<pre>
xmlns:app="http://schemas.android.com/apk/res-auto" // New namespace

app:showAsAction="ifRoom" // using 'app' namespace
</pre>

Using XML attributes from the support library.
Notice that the showAsAction attribute above uses a custom namespace defined in the <menu> tag. This is necessary when using any XML attributes defined by the support library, because these attributes do not exist in the Android framework on older devices. So you must use your own namespace as a prefix for all attributes defined by the support library.
-> Menu Resource http://developer.android.com/guide/topics/resources/menu-resource.html

--------------------------------------------------------------------------------------------------------------------------------------------



MainActivity.java

<pre>
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
</pre>


->ActionBar
https://developer.android.com/guide/topics/ui/actionbar.html
