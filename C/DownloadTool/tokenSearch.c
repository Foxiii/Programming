#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "headers.h"

void findSecretToken(char* value,int size) {
    
    int i;
    char token [] = "securitytoken";
    char *begin = strstr(value, token);
    char *access =  malloc( (size+1) * sizeof (char));
    for (i = 0; i < 55; i++) {

        if (begin[i + 22] == '"') {
            access[i] = '\0';
            continue;
        }
        access[i] = begin[i + 22];
    }
    strcpy(value,access);
    free(access);

}