grammar Glib_Gloob;

expr
    : command
    ;

command
    : fetch ('|' operation)* 
    ;

fetch
    : FETCH ASTEROID '(' parameters? ')'
    ;

operation 
    : field
    | MIN '(' field ')' 
    | MAX '(' field ')'
    ;


parameters
    : assign (',' assign)*
    ;


assign 
    : ID '=' value
    ;

field
   : value
   ;


value
    : ID
    | INT
    | DATE
    | TRUE
    | FALSE
    ;

FETCH : 'FETCH';
ASTEROID : 'asteroid';
MIN : 'MIN';
MAX : 'MAX';
TRUE : 'TRUE';
FALSE : 'FALSE';
ID : [a-zA-Z][a-zA-Z]*;
INT : [0-9]+ ;
DATE : [0-9][0-9][0-9][0-9] '-' [0-9][0-9] '-' [0-9][0-9];
WS  : [ \t\r\n]+ -> skip ;
