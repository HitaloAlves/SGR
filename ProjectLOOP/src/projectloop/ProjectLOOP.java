<<<<<<< HEAD
package projectloop;

//import model.Acesso;

import java.io.File;
import model.Acesso;
//import model.Musica;



/**
 *
 * @author leonardo
 */
public class ProjectLOOP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Acesso login = new Acesso("hitaloS@gmail.com", "abcd-2017", 0);
        
        System.out.println(login.getMessage());
        
//        Musica music = new Musica();
//        
//        music.playMusica("01");

          
          new File("musicas//Leonardo").mkdir(); // Criar Diretorio
        
    }
    
}
=======

package projectloop;

//import model.Acesso;

import model.Musica;



/**
 *
 * @author leonardo
 */
public class ProjectLOOP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Acesso login = new Acesso("leonardobezerra39@gmail.com", "a1l-swko", 0);
        
        //System.out.println(login.getMessage());
        
        Musica music = new Musica();
        
        music.playMusica("01");
        
    }
    
}
=======

package projectloop;

//import model.Acesso;

import model.Musica;



/**
 *
 * @author leonardo
 */
public class ProjectLOOP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Acesso login = new Acesso("leonardobezerra39@gmail.com", "a1l-swko", 0);
        
        //System.out.println(login.getMessage());
        
        Musica music = new Musica();
        
        music.playMusica("01");
        
    }
    
}
>>>>>>> 125eae0366e311b6a06fe7e8466f82ad936982c3
