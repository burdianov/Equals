package info.testing;

public class Car {
    private int id;
    
    public Car(int id) {
    	// pentru verificare
    	System.out.println("this in constructor: " + this);
        this.id = id;
    }
    // cred ca deja ai inteles pentru ce se face Override la metoda equals
    // de fapt, aceasta e un fel de amageala, caci obiectele care o sa le comparam
    // in realitate nu intondeauna reprezinta unul si acelasi obiect, 
    // insa in programarea de toate zilele (o sa vezi peurma din practica)
    // e convenabil sa comparam obiectele dupa criteriile inventate de noi.
    // in cazul dat nou comparam dupa id. Ceea ce facem acum e caz minimalistic,
    // doar pentru antrenare, caci compararea doar a Id-ului nu e de ajuns
    // in viata de toate zilele (adica depinde de situatie)
    // Ex: Andrusa din Seliste si Andrusa din Mana is patani diferiti, 
    // dar din cauza unei greseli ei au primit buletine cu acelasi numar (id)
    // daca ii comparam dupa referinta (de exemplu dupa codul DNA), 
    // acestea is diferiti oameni, insa statul de azi inainte o sa creada 
    // ca e unul si acelasi Andrusa. 
    // Deaceea, pentru ca sa minimizam posibilitatea unei erori,
    // trebuie sa verificam daca si alte date coincid.
    // Insa totul depinde cu ce scop comparam obiectele.
    // Spre exemplu daca e pentru platirea impozitelor, bineinteles ca
    // acesti nenici cu numele Andrusa trebuie identificati aparte, ca sa nu 
    // plateasca unul in locul altuia
    // Insa daca ei spre exemplu is trantaci, si tu esti antrenor.
    // Daca ei au aceeasi greutate si aceeasi tehnica
    // tu poti liber sa-l ei la competitie sau pe unul sau pe altul - nu conteaza
    // deaceea si facem override la equals pentru scopurile noastre proprii
    // Codul de mai jos e doar un exemplu, nu inseamna ca intotdeauna se face asa
    // Adica mai jos avem doua tipuri de comparari:
    // 1 - cele care tin de referinte; 
    // 2 - cele care compara proprietatile;
    // setul de comparari din primul grup e aproximativ acelasi in toate cazurile
    // iar grupul doi poate sa contine diferite proprietati,
    // depinde de scopul pentru care compari (vezi exemplul cu Andrusa)
    @Override
    public boolean equals(Object obj) {
    	// in randul de cod "if (this == obj) return true;"
    	// se compara daca referinta obiectului din stanga lui "equals"
    	// este egala cu referinta obiectului din dreapta lui "equals"
    	// in cazul "car1.equals(car2)"
    	// "this" este egal cu "car1"
    	// iar "obj" este egal cu "car2"
    	// urmareste logurile de mai jos pentru claritate
    	System.out.println("this: " + this);
    	System.out.println("obj: " + obj);
    	
    	// deci, daca this == obj, adica referinta este aceeasi
    	// nu mai este nevoie sa comparam mai departe,
    	// deoarece ne-am convins ca este unul si acelasi obiect
    	// ex: daca DNA coincide, deja stim precis ca merge vorba 
    	//  despre aceeasi persoana si nu mai trebuie sa controlam 
    	// greutatea lui Andrusa, culoarea ochilor, satul etc.
    	// respectiv, facem "return true" si iesim din metoda
        if (this == obj) return true;
        
        // mai jos facem doua comparatii
        // 1 - daca obiectul cu care comparam (obj), adica cel ce vine ca argument
        // in metoda "equals", care in cazul "car1.equals(car2)" este "car2"
        // este egal cu null, e evident ca car1 nu este egal cu car2
        // pentru ca car1 e obiect viu, iar car2 e loc gol
        // in cazul acesta, a doua expresie "getClass() != obj.getClass()"
        // nici n-o sa fie verificata deloc, deodata o sa se intoarca false
        // 2 - daca am ajuns la comparatia "getClass() != obj.getClass()"
        // inseamna ca obj nu este egal cu null
        // deci comparam urmatoarele "getClass() != obj.getClass()"
        // aici getClass() este metoda de reflexie care intoarce 
        // numele clasei obiectului "this" inclusiv numele la package
        // urmareste logurile de mai jos pentru claritate
        System.out.println("getClass: " + getClass());
        System.out.println("obj.getClass: " + obj.getClass());
        // (apropo, getClass() e acelasi lucru ca si this.getClass())
        
        // adica, daca numele claselor nu coincid, e evident
        // ca obiectele nu poate sa fie egale
        // caci daca avem un caine si o pisica de aceeasi greutate
        // cu aceeasi culoare a ochilor, etc. oricum is animale diferite.
        // corespuzator intoarcem false
        if (obj == null || getClass() != obj.getClass()) return false;
        
        // aici deja am trecut cu succes toate conditiile de mai sus
        // adica stim precis ca "obj" este de tip "Car"
        // insa oricum ca sa-i putem citi proprietatile
        // trebuie sa-i facem casting in "Car" deoarece el este de tip "Object"
        Car car = (Car) obj;
        
        // acum "obj" a fost transformat intr-un obiect curat de tip Car
        // si putem liber sa comparam id-ul obiectului "this" cu id-ul obiectului
        // "obj" care deja l-am transformat in "car"
        // randul de cod "if (id != car.id)" putea fi scris pentru claritate
        // si asa "if (this.id != car.id)"
        // deci, daca id-urile is diferite, inseamna ca si obiectele is diferite
        // intoarcem false
        if (id != car.id) return false;
        
        // deoarece n-a mai ramas nici o conditie, inseamna ca am trecut 
        // de toate cu succes, si inseamna ca obiectele comparate is egale
        return true;
    }
    
    // Sa tii minte pe viitor, ca daca se face override la equals,
    // e obligatoriu sa facem override si la hashCode
    // Internetul spune ca daca nu facem override la hashCode, atunci
    // equals poate sa dea uneori rezultat gresit
    // insa nu am exemple concrete care ar demonstra acest fapt
    // Oricum, sa tii minte si oricine nu te-ar intreba,
    // sa spui ca daca faci override la equals automat faci si la hashCode
    
    @Override
    public int hashCode() {
    	// Aici scriem cod pentru a crea un hashCode nou
    	// de fapt acum nu scrim nimic, ca sa nu te confuzionezi
    	// deoarece se poate de scris in diferite feluri
    	// insa pe parcurs o sa mai revizitezi aceasta tema
    	// si singur o sa gasesti exemple in internet
    	// int newHashCode = AA + CC + ... * ... / ....;
    	// return newHashCode;
    	return super.hashCode();
    }
}
