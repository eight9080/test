package com.example.designpatterns.factory.factory1;

import com.example.designpatterns.factory.factory1.cars.NullCar;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AutoFactory {

    private Map<String, Class<IAuto>> autoTypes = new HashMap<>();

    public AutoFactory() throws IOException {
        getCarTypes();
    }

    public IAuto createInstance(String carName) throws IllegalAccessException, InstantiationException {

        final Optional<? extends Class<IAuto>> typeToCreate = getTypeToCreate(carName);
        if(!typeToCreate.isPresent()){
            System.out.println("No type found for name "+ carName);
            return NullCar.NULL_CAR;
        }

        final Class<IAuto> aClass = typeToCreate.get();
        return aClass.newInstance();
    }

    private Optional<? extends Class<IAuto>> getTypeToCreate(String carName){
        return autoTypes.entrySet().stream()
                .filter(entry -> entry.getKey().contains(carName))
                .map(Map.Entry::getValue)
                .findFirst();
    }

    /**
     * get classes from a package
     * @throws IOException
     */
    private void getCarTypes() throws IOException {
//        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        final ImmutableSet<ClassPath.ClassInfo> topLevelClasses = ClassPath.from(ClassLoader.getSystemClassLoader()).getTopLevelClasses("com.example.designpatterns.factory.factory1.cars");
        System.out.println("TopLevel classes size: "+topLevelClasses.size());
        for (ClassPath.ClassInfo classInfo: topLevelClasses) {

            final Class<?> aClass = classInfo.load();
            if(IAuto.class.isAssignableFrom(aClass)) {
                autoTypes.put(aClass.getSimpleName().toLowerCase(), (Class<IAuto>) aClass);
                System.out.println("Classes added to autoTypes"+aClass.getSimpleName().toLowerCase());
            }
        }
    }


}
