Rezolvare tema

Am creat interfetele Visitable si Payable : in Visitable am o metoda
pentru a afla costul intrarii si in Visitable am implementat orarul de vizita folosing 
un Map cu cheile zile ale saptamanii si valorile intervale de timp in care se pot efectua vizite .
In main am creat obiecte de tipul Church,Concert,Statue. Am initializat o calatorie si un plan de calatorie , in care am pus 
atractiile pe care vreau sa le vizitez, impreuna cu zilele in care sunt dispus sa le vizitez. La final am afisat si atractiile 
care pot fi vizitate pe gratis, in cazul meu bisericile . Nu am considerat statuile ca fiind atractii cu intrare gratis. Clasele Church si 
Concert extind clasa abstracta Attraction , iar Church implementeaza doar interfata Visitable deoarece am considerat ca nu trebuie sa platesti
ca sa poti intra intr-o biserica , in timp ce Concert implementeaza ambele interfete.
