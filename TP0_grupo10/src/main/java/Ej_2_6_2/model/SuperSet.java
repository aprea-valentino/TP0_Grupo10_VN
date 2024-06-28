package Ej_2_6_2.model;

import Ej_2_6_2.utils.setUtils;

public class SuperSet extends StaticSet implements ISuperSet{


    @Override
    public boolean esSubconjunto(Set conjunto) {
        Set copia = setUtils.copy(conjunto);
        boolean esSubconjunto = false;
        while(!copia.isEmpty()){
            boolean aux = false;
            int x = copia.choose();
            for(int i = 0; i < count; i++){
                if (this.array[i] == x){
                    aux = true;
                }
            }
            if(aux){
                esSubconjunto = true;
            }else {esSubconjunto = false;}
            copia.remove(x);
        }
        return esSubconjunto;
    }

    @Override
    public Set Complemento(Set conjunto) {
        Set complemento = new StaticSet();
        if(!esSubconjunto(conjunto)){
            System.out.println("No se puede complementar ya que no es subconjunto");
            return null;
        }else {
            Set copia = setUtils.copy(conjunto);
            for(int i = 0; i < count; i++) {
                if (!setUtils.in(this.array[i], copia)){
                    complemento.add(this.array[i]);
                }
            }

        }
        return complemento;
    }
}
