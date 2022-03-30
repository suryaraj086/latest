package pojo;

public enum SingletonTask {
	SINGLETON;
}


//private static SingletonTask instance;
//
//public static synchronized getInstance(){
//    if(instance == null){
//        instance = new SingletonTask();
//    }
//    return instance;
//}
//}


//public static getInstanceUsingDoubleLocking(){
//    if(instance == null){
//        synchronized (SingletonTask.class) {
//            if(instance == null){
//                instance = new SingletonTask();
//            }
//        }
//    }
//    return instance;
//}