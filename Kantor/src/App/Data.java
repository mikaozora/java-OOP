package App;

import java.util.ArrayList;

public class Data<T> {
    private ArrayList<T> arr;
    public Data(ArrayList<T> data){
        this.arr = data;
    }

    public void viewData(){
        int i = 1;
        for(T data : arr){
            if(data instanceof Manager manager){
                System.out.println(i+". "+manager.getName() + ", salary: " + manager.getSalary());
            }else if(data instanceof VicePresident vp){
                System.out.println(i+". "+vp.getName() + ", salary: " + vp.getSalary() +", age: " + vp.getAge());
            }
            i++;
        }
    }
    public void push(T data){
        arr.add(data);
    }
    public void update(int index, T data){
//        if(data instanceof Manager){
//            arr.set(index, data);
//        }else if(data instanceof VicePresident){
//            arr.set(index, data);
//        }
        arr.set(index, data);
    }
    public void updateSalary(int salary, T data){
        if(data instanceof VicePresident vp){
            vp.setSalary(salary);
        }
    }
    public void delete(int index){
        arr.remove(index);
    }
    public T find(String name){
        for(T data : arr){
            if(data instanceof VicePresident vp){
                if(name.equals(vp.getName())){
                    return data;
                }
            }else if(data instanceof Manager manager){
                if(name.equals(manager.getName())){
                    return data;
                }
            }
        }
        return null;
    }
    public ArrayList<T> getData(){
        return arr;
    }

}
