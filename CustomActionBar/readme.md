
#Comments

Create Menu Layout:
menu/menu_main.xml

<pre>
xmlns:app="http://schemas.android.com/apk/res-auto" // New namespace

app:showAsAction="ifRoom" // using 'app' namespace
</pre>
-> Menu Resource http://developer.android.com/guide/topics/resources/menu-resource.html

--------------------------------------------------------------------------------------------------------------------------------------------


Create Menu at Top:
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
