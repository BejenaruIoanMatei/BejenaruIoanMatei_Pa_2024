Rezolvare

Solutia problemei cu repartizarea vehiculelor
catre fiecare client am implementat-o in 
clasa Problem, care contine urmatoarele :
O lista de depozite, o lista de clienti, o lista
de vehicule si un vector in care generez random valori.
Vectorul reprezinta durata distantelor intre fiecare clienti, iar
pozitia 0 in vector (cea initiala) este reprezentata de depou.
Vehiculul pleaca din depou la cel mai apropiat client nevizitat si 
il adauga la tour. In functie de clientul adaugat turului alegem 
urmatorul client, ca fiind cel mai apropiat client de clientul nostru.
