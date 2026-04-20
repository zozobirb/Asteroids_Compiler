grammar Glib_Gloob;

command
    : fetch ('|' operation)* 
    ;

fetch
    : FETCH ASTEROID '(' parameters? ')'
    ;

operation 
    : MIN '(' field ')' 
    | MAX '(' field ')'
    ;

parameters
    : assign (',' assign)*
    ;

assign
    : ID '=' value
    ;

value
    : ID
    | INT
    | DATE
    | TRUE
    | FALSE
    ;

field
    : DISTANCE
    | SIZE
    ;

FETCH : 'FETCH';
ASTEROID : 'asteroid';
MIN : 'MIN';
MAX : 'MAX';
DISTANCE : 'distance';
SIZE : 'size';
TRUE : 'TRUE';
FALSE : 'FALSE';

ID  : [a-zA-Z_][a-zA-Z_0-9]* ;
INT : [0-9]+ ;
DATE : [0-9][0-9][0-9][0-9] '-' [0-9][0-9] '-' [0-9][0-9];
WS  : [ \t\r\n]+ -> skip ;