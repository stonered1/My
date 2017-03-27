package my2017.sidebardemo.bean;

import java.util.Locale;

/**
 * @author Stone
 * @version V1.0
 * @description:
 * @date 17/3/26 09:23
 * @email redsstone@163.com
 */
public class DataBean {

    private String firstLetter;
    private String name;

    public String getFirstLetter() {
        //将name的首写字母转换为大写
        return name.substring(0,1).toUpperCase(Locale.CHINA);
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "firstLetter='" + firstLetter + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
