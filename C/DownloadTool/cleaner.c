
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include "headers.h"


void cleaner(char* enter){
    int i;
   char* output =(char*) malloc(strlen(enter)*sizeof(char));
    
    for (i = 0; i < strlen(enter); i++) {

        if (i == (strlen(enter) - 1)) {
            output[i] = '\0';
            continue;
        }
        output[i] = enter[i];
    }
   strcpy(enter,output);
   free(output);
}