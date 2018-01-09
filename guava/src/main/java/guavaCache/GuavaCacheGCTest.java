package guavaCache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * @author huangyipeng1
 **/
public class GuavaCacheGCTest {

    static Object a = new Object();

    public static void main(String[] args) {

        Cache cache = createSoftValuesCache();
        cache.put(new String("testKey"), new String("testValue"));

        System.out.println(cache.getIfPresent("testKey"));
        System.out.println(cache.asMap());
        System.gc();
        System.out.println(cache.asMap());
    }

    private static Cache createStrongCache() {
        return CacheBuilder.newBuilder().build();
    }

    // weakKey模式下，key如果是存在常量池，则weak特性失效
    private static Cache createWeakKeysCache() {

        return CacheBuilder.newBuilder().weakKeys().build();
    }

    private static Cache createWeakValuesCache() {

        return CacheBuilder.newBuilder().weakValues().build();
    }

    private static Cache createSoftValuesCache() {

        return CacheBuilder.newBuilder().softValues().build();
    }


}
