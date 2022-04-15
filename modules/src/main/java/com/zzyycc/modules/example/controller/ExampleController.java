package com.zzyycc.modules.example.controller;

import com.zzyycc.common.core.utils.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author zhuyuechao
 * @version 1.0.0
 * @className ExampleController
 * @createTime 2022/4/8 16:23
 * @description
 */
@RestController
@RequestMapping("/example")
@Api(value = "example", tags = "示例")
public class ExampleController {


    @ApiOperation(value = "爬数据")
    @PostMapping("/netdata")
    public ResponseData<String> netData() {
        String s = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建httpget
            HttpGet httpget = new HttpGet("https://www.48wx.org/1_1053/97448.html");
            RequestConfig build = RequestConfig.custom().setSocketTimeout(5000)
                    .setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .build();
            httpget.setConfig(build);
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            // 获取响应实体
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                // 打印响应内容
                String s1 = EntityUtils.toString(entity, "GBK");




                Document parse = Jsoup.parse(s1);
                Element content = parse.getElementById("content");
                s = content.wholeText();
                //s = StringUtils.replace(s, " ", "");


            }


        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




        return ResponseData.success(s);



    }

    @ApiOperation(value = "爬数据")
    @PostMapping("/xml")
    public ResponseData<String> xml() {
        String result = null;

        String a = "<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title> 《老婆的性感开发之旅》第一章（上）_老婆的性感开发之旅_辣文小说_48文学网</title>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gbk\" />\n" +
                "<meta name=\"keywords\" content=\"老婆的性感开发之旅, 《老婆的性感开发之旅》第一章（上）\" />\n" +
                "<meta name=\"description\" content=\"48文学网提供了午夜人屠创作的辣文小说《老婆的性感开发之旅》干净清爽无错字的文字章节： 《老婆的性感开发之旅》第一章（上）在线阅读。\" />\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.48wx.org/images/biquge.css\"/>\n" +
                "<script type=\"text/javascript\" src=\"https://libs.baidu.com/jquery/1.4.2/jquery.min.js\"></script>\n" +
                "<!--<script type=\"text/javascript\" src=\"http://cbjs.baidu.com/js/m.js\"></script>-->\n" +
                "<script type=\"text/javascript\" src=\"https://www.48wx.org/images/bqg.js\"></script>\n" +
                "<script src=\"/images/uaredirect.js\" type=\"text/javascript\"></script>\n" +
                "<script type=\"text/javascript\">uaredirect(\"https://m.48wx.org/1_1053/97447.html\");</script>\n" +
                "<script type=\"text/javascript\">var preview_page = \"/1_1053/\";var next_page = \"/1_1053/97448.html\";var index_page = \"/1_1053/\";var article_id = \"1053\";\tvar chapter_id = \"97447\";\tfunction jumpPage() {var event = document.all ? window.event : arguments[0];if (event.keyCode == 37) document.location = preview_page;if (event.keyCode == 39) document.location = next_page;if (event.keyCode == 13) document.location = index_page;}document.onkeydown=jumpPage;</script>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<div id=\"wrapper\">\n" +
                "\t\t<script>login();</script>\n" +
                "\t\t<div class=\"header\">\n" +
                "\t\t\t<div class=\"header_logo\">\n" +
                "\t\t\t\t<a href=\"https://www.48wx.org\">48文学网</a>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<script>bqg_panel();</script>            \n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"nav\">\n" +
                "\t\t\t<ul>\n" +
                "\t\t\t\t<li><a href=\"https://www.48wx.org/\">首页</a></li>\n" +
                "\t\t\t\t<li><a href=\"/xuanhuanxiaoshuo/\">玄幻小说</a></li>\n" +
                "\t\t\t\t<li><a href=\"/xiuzhenxiaoshuo/\">修真小说</a></li>\n" +
                "\t\t\t\t<li><a href=\"/dushixiaoshuo/\">都市小说</a></li>\n" +
                "\t\t\t\t<li><a href=\"/chuanyuexiaoshuo/\">架空历史</a></li>\n" +
                "\t\t\t\t<li><a href=\"/kehuanxiaoshuo/\">科幻小说</a></li>\n" +
                "\t\t\t\t<li><a href=\"/paihangbang/\">排行榜单</a></li>\n" +
                "\t\t\t\t<li><a href=\"/wanben/1_1\">完本小说</a></li>\n" +
                "\t\t\t</ul>\n" +
                "\t\t</div>\n" +
                "        \n" +
                "\t\t<div class=\"content_read\">\n" +
                "\t\t\t<div class=\"box_con\">\n" +
                "\t\t\t\t<div class=\"con_top\">\n" +
                "\t\t\t\t\t<script>textselect();</script>\n" +
                "\t\t\t\t\t<a href=\"/\">48文学网</a> &gt; <a href=\"/lawenxiaoshuo/\">辣文小说</a> &gt; <a href=\"https://www.48wx.org/1_1053/\">老婆的性感开发之旅</a> &gt;  《老婆的性感开发之旅》第一章（上）\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<div class=\"bookname\">\n" +
                "\t\t\t\t\t<h1> 《老婆的性感开发之旅》第一章（上）</h1>\n" +
                "\t\t\t\t\t<div class=\"bottem1\">\n" +
                "\t\t\t\t\t\t<a href=\"javascript:;\" onclick=\"showpop('/modules/article/uservote.php?id=1053&ajax_request=1');\">投推荐票</a> <a href=\"/1_1053/\">上一章</a> &larr; <a href=\"https://www.48wx.org/1_1053/\">章节目录</a> &rarr; <a href=\"/1_1053/97448.html\">下一章</a> <a href=\"javascript:;\" onclick=\"showpop('/modules/article/addbookcase.php?id=1053&cid=97447&ajax_request=1');\">加入书签</a>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"lm\">&nbsp;热门推荐：<a href='/0_808/' >全职法师</a>\n" +
                "\t\t\t\t<a href='/1_1561/' style='font-weight:bold'>日光女神</a>\n" +
                "\t\t\t\t<a href='/2_2600/' >圣墟</a>\n" +
                "\t\t\t\t<a href='/9_9551/' >春的故事</a>\n" +
                "\t\t\t\t<a href='/0_833/' style='font-weight:bold'>神荒龙帝</a>\n" +
                "\t\t\t\t<a href='/10_10150/' >情欲急诊科（急诊科医生同人）</a>\n" +
                "\t\t\t\t<a href='/1_1293/' style='font-weight:bold'>警花相伴</a>\n" +
                "\t\t\t\t<a href='/2_2602/' >武炼巅峰</a>\n" +
                "\t\t\t\t<a href='/1_1053/' >老婆的性感开发之旅</a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<table style=\"width:100%; text-align:center;\"><tr><td><script>read_1_1();</script></td><td><script>read_1_2();</script></td><td><script>read_1_3();</script></td></tr></table>\n" +
                "\t\t\t\t<div id=\"content\">《老婆的性感开发之旅》第一章（上）<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;【2016-02-27】<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;《一》大学时代（一）设计迷奸（上）<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;２００４年，我以优异的成绩考入了我省一所重点大学，和我一起入学的还有我相恋了２年的女朋友——小欣。其实确切的说我们是一起长大的，小时候能传出来的，所以今天我也只能在这里去偷听我心爱的女友被人迷奸的场景了。</div>\n" +
                "\t\t\t\t<div class=\"bottem2\">\n" +
                "\t\t\t\t\t<a href=\"javascript:;\" onclick=\"showpop('/modules/article/uservote.php?id=1053&ajax_request=1');\">投推荐票</a> <a href=\"/1_1053/\">上一章</a> &larr; <a href=\"https://www.48wx.org/1_1053/\">章节目录</a> &rarr; <a href=\"/1_1053/97448.html\">下一章</a> <a href=\"javascript:;\" onclick=\"showpop('/modules/article/addbookcase.php?id=1053&cid=97447&ajax_request=1');\">加入书签</a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<div id=\"hm_t_20123\"></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"footer\">\n" +
                "\t\t    <div class=\"footer_link\">&nbsp;新书推荐：<a href='/10_10538/' >游戏世界随心所欲</a>\n" +
                "\t\t\t\t<a href='/10_10537/' style='font-weight:bold'>倚天 逍遥仙</a>\n" +
                "\t\t\t\t<a href='/10_10536/' >淫堕魔女</a>\n" +
                "\t\t\t\t<a href='/10_10535/' >婉儿</a>\n" +
                "\t\t\t\t<a href='/10_10534/' style='font-weight:bold'>闷骚技师的骚丝诱惑</a>\n" +
                "\t\t\t\t<a href='/10_10533/' >外表清纯的女友青青</a>\n" +
                "\t\t\t\t<a href='/10_10532/' style='font-weight:bold'>游戏世界大冒险</a>\n" +
                "\t\t\t\t<a href='/10_10531/' >芥末婚姻之丑事录</a>\n" +
                "\t\t\t\t<a href='/10_10530/' >魔物传</a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t<div class=\"footer_cont\">\n" +
                "\t\t\t\t<script>footer();right();dl();</script>\n" +
                "\t\t\t\t<!--<script>mark();</script>-->\n" +
                "                <div class=\"reader_mark1\"><a href=\"javascript:;\" onclick=\"showpop('/modules/article/addbookcase.php?id=1053&cid=97447&ajax_request=1');\"></a></div>\n" +
                "                <div class=\"reader_mark0\"><a href=\"javascript:;\" onclick=\"showpop('/modules/article/uservote.php?id=1053&ajax_request=1');\"></a></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div id=\"tip\" style=\"margin:0px;color:#444;font-siz:14px;\"></div>\n" +
                "</body>\n" +
                "<script charset=\"gbk\" src=\"https://www.baidu.com/js/opensug.js\"></script>\n" +
                "</html>";

        Document parse = Jsoup.parse(a);
        Element content = parse.getElementById("content");
        String text = content.text();
        return ResponseData.success(text);
    }







}
