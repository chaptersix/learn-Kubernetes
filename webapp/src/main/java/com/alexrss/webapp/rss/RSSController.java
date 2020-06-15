package com.alexrss.webapp.rss;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndEntry;
// import com.rometools.rome.feed.synd.SyndFeedImpl;
// import com.rometools.rome.io.SyndFeedOutput;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

@Controller
public class RSSController {
    @GetMapping("/rss-feed")
    @ResponseBody
    public List<SyndEntry> getRSSFeed() throws MalformedURLException, FeedException, IOException {
        URL inputUrl = new URL("https://www.theverge.com/rss/index.xml");
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(inputUrl));
        return (feed.getEntries());
    }

}
