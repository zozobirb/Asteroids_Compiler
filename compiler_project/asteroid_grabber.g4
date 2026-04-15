grammar Expr ; 

expr
    : cond
    ;

cond
    : add
    | add '?' expr ':' cond
    ;

add : mul (('+'|'-') mul)* ;
mul : unary (('*'|'/') unary)* ;

unary
    : primary
    ;

primary
    : INT
    | ID
    | '(' expr ')'
    ;

INT : [0-9]+ ;
ID  : [a-zA-Z_][a-zA-Z_0-9]* ;
WS  : [ \t\r\n]+ -> skip ;
