#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <curl/curl.h>
#include <curl/easy.h>
#include <string.h>
#include"headers.h"


void doLogin(char* username , char* mdString,CURL* myHandle){
    int i;
    char data[500];
    for(i=0;i<500;i++) data[i] = '\0';
    strcat(data, "do=login&url=%2Fforum%2Findex.php&vb_login_md5password=");
    strcat(data, mdString);
    strcat(data, "&vb_login_md5password_utf=");
    strcat(data,mdString);
    strcat(data,"&s=&securitytoken=guest&vb_login_username=");
    strcat(data,username);
    strcat(data,"&vb_login_password=");
    
    
    // curl_easy_setopt(myHandle, CURLOPT_PROXY, "http://127.0.0.1:8080/");
    curl_easy_setopt(myHandle, CURLOPT_USERAGENT, "Mozilla/4.0");
    curl_easy_setopt(myHandle, CURLOPT_AUTOREFERER, 1);
    curl_easy_setopt(myHandle, CURLOPT_FOLLOWLOCATION, 1);
    curl_easy_setopt(myHandle, CURLOPT_COOKIESESSION, 1);
    curl_easy_setopt(myHandle, CURLOPT_URL, "http://usenet-4all.info/forum/login.php?do=login");
    curl_easy_setopt(myHandle, CURLOPT_REFERER, "http://usenet-4all.info/forum/index.php");
    curl_easy_setopt(myHandle, CURLOPT_COOKIEFILE, "cookievb.txt");
    curl_easy_setopt(myHandle, CURLOPT_COOKIEJAR, "cookievb.txt");
    curl_easy_setopt(myHandle, CURLOPT_POSTFIELDS, data);
    curl_easy_setopt(myHandle, CURLOPT_TCP_KEEPALIVE, 50L);
    curl_easy_perform(myHandle);

}

