
#Comments

Create Menu Layout:
menu/menu_main.xml

xmlns:app="http://schemas.android.com/apk/res-auto" // New namespace

app:showAsAction="ifRoom" // using 'app' namespace

-> Menu Resource
http://developer.android.com/guide/topics/resources/menu-resource.html
--------------------------------------------------------------------------------------------------------------------------------------------


Create Menu at Top:
MainActivity.java

<code>
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
</code>


->ActionBar
https://developer.android.com/guide/topics/ui/actionbar.html
