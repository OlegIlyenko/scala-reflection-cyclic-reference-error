import net.sf.ehcache.{Cache, Ehcache, CacheManager}
import play.api.inject.ApplicationLifecycle

import scala.reflect.runtime.universe.typeOf

object ErrorTest extends App {

  // OK - works as expected

  typeOf[CacheManager] <:< typeOf[CacheManager]
  typeOf[ApplicationLifecycle] <:< typeOf[ApplicationLifecycle]
  typeOf[Ehcache] <:< typeOf[Cache]

  // all lines blow throw an exception: scala.reflect.internal.Symbols$CyclicReference: illegal cyclic reference involving type T

  typeOf[java.util.Date] <:< typeOf[net.sf.ehcache.CacheManager]
  typeOf[Ehcache] <:< typeOf[CacheManager]
  typeOf[ApplicationLifecycle] <:< typeOf[CacheManager]
  typeOf[CacheManager] <:< typeOf[ApplicationLifecycle]

}
