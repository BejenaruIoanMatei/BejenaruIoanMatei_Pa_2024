Rezolvare

--> Compulsory

Am urmat pasii din laborator. 
Am folosit Integer.parseInt() pentru parsare.
Am calculat cifra de control in suma cifrelor pentru rezultatul obtinut din pasii anteriori.

-->Homework

In rezolvarea temei am folosit o clasa principala (Lab1) in care sa preiau valorile din linia de comanda, urmand sa le validez corespunzator
.Pe langa clasa Lab1 am creat o clasa separata Calcul, unde am implementat algoritmul pentru k-reductibilitate. In Lab1 am 
creat o instanta a clasei Calcul si am atribuit referinta acestei instante variabilei -numere- , folosindu-ma de referinta pentru a apela
metoda -reductibil(int,int,int)-

-->Bonus

Am creat o clasa separata de Main , numita -WheelGraph- , unde am implementat metodele -makeMatrix(int)- si -displayMatrix(int[][])-
. In -makeMatrix- creez matricea 
adiacenta pentru un graf roata 
cu un numar de noduri -n- dat ca parametru. 
Nodul 0 este hub-ul. Nodurile exterioare sunt 
conectate la hub. La fel se conecteaza nodurile exterioare 
intre ele pentru a forma un ciclu. La final 
se adauga o muchie intre primul nod si ultimul
pentru a inchide ciclul. Se returneaza matricea de adiacenta
rezultata. Numarul total de cicluri poate fi calculat
intr-o variabila astfel : (n-2)(n-1)+1 . Avem un ciclu care
nu trece prin centru(hub), adica +1 . Restul de 
cicluri trec prin centru si trebuie sa 
alegem doua noduri care trec prin hub, deci
avem combinari de (n-1) luate cate 2 -> alegeri.
Si pentru fiecare pereche de genul asta avem
doua alegeri : prima ia calea de sus si a doua
calea de jos . Asadar avem 2*(combinari (n-1) luate cate 2) + 1. 
Facand calculul obtinem 2 * ((n-2)(n-1))/2 + 1 =
(n-2)(n-1)+1.



