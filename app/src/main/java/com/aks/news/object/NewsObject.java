package com.aks.news.object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 8/4/2016.
 */

public class NewsObject {

    private String imageUrl;
    private String title;
    private String date;
    private String desc;
    private String detailUrl;

    public NewsObject(String imageUrl, String title, String date, String desc, String detailUrl) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.date = date;
        this.desc = desc;
        this.detailUrl = detailUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    private static List<NewsObject> newsObjectList = new ArrayList<>();

    public static List<NewsObject> getNewsObjectList() {
        return newsObjectList;
    }

    static {
        for (int i=0; i<3; i++) {
            newsObjectList.add(new NewsObject( "https://tctechcrunch2011.files.wordpress.com/2016/08/gettyimages-584268466.jpg?w=764&amp;h=400&amp;crop=1",
                    "New York Governor signs daily fantasy sports bill, DraftKings and FanDuel can operate again",
                    "2016-08-04T04:20:46Z",
                    "Back in June on the last day of the New York Assembly's legislative session, the state passed a bill legalizing daily fantasy sports, paving the road for the..",
                    "http://social.techcrunch.com/2016/08/03/new-york-governor-signs-daily-fantasy-sports-bill-draftkings-and-fanduel-can-operate-again/"
            ));

            newsObjectList.add(new NewsObject( "https://img.vidible.tv/prod/2016-08/03/57a274e1134aa15a39f04209_1280x720_U_v1_764_400.jpg",
                    "Crunch Report | First private company to go to the Moon",
                    "2016-08-04T03:00:38Z",
                    "Moon Express is the first private company to get permission from the U.S. government to go to the moon, Facebook shows us its \"Area 404\" hardware lab, Tesla..",
                    "http://social.techcrunch.com/2016/08/03/crunch-report-first-private-company-to-go-to-the-moon/"
            ));

            newsObjectList.add(new NewsObject( "https://tctechcrunch2011.files.wordpress.com/2016/07/gettyimages-589718629.jpg?w=764&amp;h=400&amp;crop=1",
                    "AirHelp raises $12 million to deal with airline customer service for you",
                    "2016-08-04T02:46:45Z",
                    "Few things are more dreadful than dealing with airline customer service. Fortunately, there’s a startup that wants to make those calls for you. For..",
                    "http://social.techcrunch.com/2016/08/03/airhelp-raises-12-million-to-deal-with-airline-customer-service-for-you/"
            ));
        }
    }
}

