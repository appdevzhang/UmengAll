package appdevzhang.com.umengall.bean;

import java.io.Serializable;

/**
 * @ClassName: Wheather
 * @Description:
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/8/28 上午11:39
 */
public class Wheather implements Serializable{
    private  WheatherInfo weatherinfo;

    public WheatherInfo getWeatherinfo() {
        return weatherinfo;
    }

    public void setWeatherinfo(WheatherInfo weatherinfo) {
        this.weatherinfo = weatherinfo;
    }

    @Override
    public String toString() {
        return "Wheather{" +
                "weatherinfo=" + weatherinfo +
                '}';
    }
}
