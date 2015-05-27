package in.jmj.webservice;

/**
 * Created by joseph on 27/5/15.
 */
public class MyKeyValueList {

    String key;
    String value;

    public MyKeyValueList() {
        super();
    }

    public MyKeyValueList(String key, String value) {
        super();
        this.key = key;
        this.value = value;

    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
//        return super.toString();
        return this.value;
    }
}
