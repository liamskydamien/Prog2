package Einführung;

public class Helper {
    public void move(IntegerBuffer pSource, IntegerBuffer pDest){
      for(int i = 0; i < pSource.capacity(); i++){
          pDest.push(pSource.pop());
      }
    }
}
