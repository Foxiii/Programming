/* 
 * File:   headers.h
 * Author: Thorsten
 *
 * Created on 18. August 2015, 12:55
 */
#ifndef HEADERS_H
#define HEADERS_H
#include <curl/curl.h>
#include <curl/easy.h>

struct string {
    char *ptr;
    size_t len;
};
extern int meineVariable;
size_t writefunc(void *ptr, size_t size, size_t nmemb, struct string *s);
static void print_cookies(CURL *curl);
int match(const char *string, char *pattern);
#endif 