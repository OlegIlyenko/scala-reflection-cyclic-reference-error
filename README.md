Attempt to reproduce a bug in scala reflection API.

Following exception is thrown:



```
Exception in thread "main" scala.reflect.internal.Symbols$CyclicReference: illegal cyclic reference involving type T
        at scala.reflect.internal.Symbols$Symbol$$anonfun$info$3.apply(Symbols.scala:1471)
        at scala.reflect.internal.Symbols$Symbol$$anonfun$info$3.apply(Symbols.scala:1469)
        at scala.Function0$class.apply$mcV$sp(Function0.scala:40)
        at scala.runtime.AbstractFunction0.apply$mcV$sp(AbstractFunction0.scala:12)
        at scala.reflect.internal.Symbols$Symbol.lock(Symbols.scala:528)
        at scala.reflect.internal.Symbols$Symbol.info(Symbols.scala:1469)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anon$11.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info(SynchronizedSymbols.scala:159)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anonfun$info$1.apply(SynchronizedSymbols.scala:127)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anonfun$info$1.apply(SynchronizedSymbols.scala:127)
        at scala.reflect.runtime.Gil$class.gilSynchronized(Gil.scala:19)
        at scala.reflect.runtime.JavaUniverse.gilSynchronized(JavaUniverse.scala:16)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$class.gilSynchronizedIfNotThreadsafe(SynchronizedSymbols.scala:123)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anon$11.gilSynchronizedIfNotThreadsafe(SynchronizedSymbols.scala:159)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$class.info(SynchronizedSymbols.scala:127)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anon$11.info(SynchronizedSymbols.scala:159)
        at scala.reflect.internal.Types$$anonfun$31.apply(Types.scala:3746)
        at scala.reflect.internal.Types$$anonfun$31.apply(Types.scala:3745)
        at scala.reflect.internal.util.Collections$class.mapWithIndex(Collections.scala:190)
        at scala.reflect.internal.SymbolTable.mapWithIndex(SymbolTable.scala:16)
        at scala.reflect.internal.Types$class.typeParamsToExistentials(Types.scala:3745)
        at scala.reflect.internal.SymbolTable.typeParamsToExistentials(SymbolTable.scala:16)
        at scala.reflect.internal.Types$class.typeParamsToExistentials(Types.scala:3751)
        at scala.reflect.internal.SymbolTable.typeParamsToExistentials(SymbolTable.scala:16)
        at scala.reflect.internal.tpe.TypeMaps$$anon$1.apply(TypeMaps.scala:332)
        at scala.reflect.runtime.JavaMirrors$JavaMirror.typeToScala(JavaMirrors.scala:1081)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$TypeParamCompleter$$anonfun$complete$1.apply(JavaMirrors.scala:661)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$TypeParamCompleter$$anonfun$complete$1.apply(JavaMirrors.scala:661)
        at scala.collection.immutable.List.map(List.scala:273)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$TypeParamCompleter.complete(JavaMirrors.scala:661)
        at scala.reflect.internal.Symbols$Symbol.info(Symbols.scala:1483)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anon$11.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info(SynchronizedSymbols.scala:159)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anonfun$info$1.apply(SynchronizedSymbols.scala:127)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anonfun$info$1.apply(SynchronizedSymbols.scala:127)
        at scala.reflect.runtime.Gil$class.gilSynchronized(Gil.scala:19)
        at scala.reflect.runtime.JavaUniverse.gilSynchronized(JavaUniverse.scala:16)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$class.gilSynchronizedIfNotThreadsafe(SynchronizedSymbols.scala:123)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anon$11.gilSynchronizedIfNotThreadsafe(SynchronizedSymbols.scala:159)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$class.info(SynchronizedSymbols.scala:127)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anon$11.info(SynchronizedSymbols.scala:159)
        at scala.reflect.internal.Types$$anonfun$31.apply(Types.scala:3746)
        at scala.reflect.internal.Types$$anonfun$31.apply(Types.scala:3745)
        at scala.reflect.internal.util.Collections$class.mapWithIndex(Collections.scala:190)
        at scala.reflect.internal.SymbolTable.mapWithIndex(SymbolTable.scala:16)
        at scala.reflect.internal.Types$class.typeParamsToExistentials(Types.scala:3745)
        at scala.reflect.internal.SymbolTable.typeParamsToExistentials(SymbolTable.scala:16)
        at scala.reflect.internal.Types$class.typeParamsToExistentials(Types.scala:3751)
        at scala.reflect.internal.SymbolTable.typeParamsToExistentials(SymbolTable.scala:16)
        at scala.reflect.internal.tpe.TypeMaps$$anon$1.apply(TypeMaps.scala:332)
        at scala.reflect.runtime.JavaMirrors$JavaMirror.typeToScala(JavaMirrors.scala:1081)
        at scala.reflect.runtime.JavaMirrors$JavaMirror.scala$reflect$runtime$JavaMirrors$JavaMirror$$jfieldAsScala1(JavaMirrors.scala:1126)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$$anonfun$scala$reflect$runtime$JavaMirrors$JavaMirror$$jfieldAsScala$1.apply(JavaMirrors.scala:1121)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$$anonfun$scala$reflect$runtime$JavaMirrors$JavaMirror$$jfieldAsScala$1.apply(JavaMirrors.scala:1121)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$$anonfun$toScala$1.apply(JavaMirrors.scala:97)
        at scala.reflect.runtime.TwoWayCaches$TwoWayCache$$anonfun$toScala$1.apply(TwoWayCaches.scala:39)
        at scala.reflect.runtime.Gil$class.gilSynchronized(Gil.scala:19)
        at scala.reflect.runtime.JavaUniverse.gilSynchronized(JavaUniverse.scala:16)
        at scala.reflect.runtime.TwoWayCaches$TwoWayCache.toScala(TwoWayCaches.scala:34)
        at scala.reflect.runtime.JavaMirrors$JavaMirror.toScala(JavaMirrors.scala:95)
        at scala.reflect.runtime.JavaMirrors$JavaMirror.scala$reflect$runtime$JavaMirrors$JavaMirror$$jfieldAsScala(JavaMirrors.scala:1121)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$FromJavaClassCompleter$$anonfun$completeRest$1$$anonfun$apply$mcV$sp$1$$anonfun$apply$mcV$sp$3.apply(JavaMirrors.scala:776)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$FromJavaClassCompleter$$anonfun$completeRest$1$$anonfun$apply$mcV$sp$1$$anonfun$apply$mcV$sp$3.apply(JavaMirrors.scala:776)
        at scala.collection.IndexedSeqOptimized$class.foreach(IndexedSeqOptimized.scala:33)
        at scala.collection.mutable.ArrayOps$ofRef.foreach(ArrayOps.scala:186)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$FromJavaClassCompleter$$anonfun$completeRest$1$$anonfun$apply$mcV$sp$1.apply$mcV$sp(JavaMirrors.scala:776)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$FromJavaClassCompleter$$anonfun$completeRest$1.apply$mcV$sp(JavaMirrors.scala:786)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$FromJavaClassCompleter$$anonfun$completeRest$1.apply(JavaMirrors.scala:745)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$FromJavaClassCompleter$$anonfun$completeRest$1.apply(JavaMirrors.scala:745)
        at scala.reflect.runtime.Gil$class.gilSynchronized(Gil.scala:19)
        at scala.reflect.runtime.JavaUniverse.gilSynchronized(JavaUniverse.scala:16)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$FromJavaClassCompleter.completeRest(JavaMirrors.scala:745)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$FromJavaClassCompleter$LazyPolyType.complete(JavaMirrors.scala:793)
        at scala.reflect.internal.Symbols$Symbol.info(Symbols.scala:1483)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anon$8.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info(SynchronizedSymbols.scala:168)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anonfun$info$1.apply(SynchronizedSymbols.scala:127)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anonfun$info$1.apply(SynchronizedSymbols.scala:127)
        at scala.reflect.runtime.Gil$class.gilSynchronized(Gil.scala:19)
        at scala.reflect.runtime.JavaUniverse.gilSynchronized(JavaUniverse.scala:16)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$class.gilSynchronizedIfNotThreadsafe(SynchronizedSymbols.scala:123)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anon$8.gilSynchronizedIfNotThreadsafe(SynchronizedSymbols.scala:168)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$class.info(SynchronizedSymbols.scala:127)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anon$8.info(SynchronizedSymbols.scala:168)
        at scala.reflect.runtime.JavaMirrors$JavaMirror.scala$reflect$runtime$JavaMirrors$JavaMirror$$coreLookup$1(JavaMirrors.scala:987)
        at scala.reflect.runtime.JavaMirrors$JavaMirror.scala$reflect$runtime$JavaMirrors$JavaMirror$$lookupClass$1(JavaMirrors.scala:993)
        at scala.reflect.runtime.JavaMirrors$JavaMirror.scala$reflect$runtime$JavaMirrors$JavaMirror$$classToScala1(JavaMirrors.scala:998)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$$anonfun$classToScala$1.apply(JavaMirrors.scala:975)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$$anonfun$classToScala$1.apply(JavaMirrors.scala:975)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$$anonfun$toScala$1.apply(JavaMirrors.scala:97)
        at scala.reflect.runtime.TwoWayCaches$TwoWayCache$$anonfun$toScala$1.apply(TwoWayCaches.scala:39)
        at scala.reflect.runtime.Gil$class.gilSynchronized(Gil.scala:19)
        at scala.reflect.runtime.JavaUniverse.gilSynchronized(JavaUniverse.scala:16)
        at scala.reflect.runtime.TwoWayCaches$TwoWayCache.toScala(TwoWayCaches.scala:34)
        at scala.reflect.runtime.JavaMirrors$JavaMirror.toScala(JavaMirrors.scala:95)
        at scala.reflect.runtime.JavaMirrors$JavaMirror.classToScala(JavaMirrors.scala:975)
        at scala.reflect.runtime.JavaMirrors$JavaMirror.typeToScala(JavaMirrors.scala:1080)
        at scala.reflect.runtime.JavaMirrors$JavaMirror.scala$reflect$runtime$JavaMirrors$JavaMirror$$jfieldAsScala1(JavaMirrors.scala:1126)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$$anonfun$scala$reflect$runtime$JavaMirrors$JavaMirror$$jfieldAsScala$1.apply(JavaMirrors.scala:1121)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$$anonfun$scala$reflect$runtime$JavaMirrors$JavaMirror$$jfieldAsScala$1.apply(JavaMirrors.scala:1121)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$$anonfun$toScala$1.apply(JavaMirrors.scala:97)
        at scala.reflect.runtime.TwoWayCaches$TwoWayCache$$anonfun$toScala$1.apply(TwoWayCaches.scala:39)
        at scala.reflect.runtime.Gil$class.gilSynchronized(Gil.scala:19)
        at scala.reflect.runtime.JavaUniverse.gilSynchronized(JavaUniverse.scala:16)
        at scala.reflect.runtime.TwoWayCaches$TwoWayCache.toScala(TwoWayCaches.scala:34)
        at scala.reflect.runtime.JavaMirrors$JavaMirror.toScala(JavaMirrors.scala:95)
        at scala.reflect.runtime.JavaMirrors$JavaMirror.scala$reflect$runtime$JavaMirrors$JavaMirror$$jfieldAsScala(JavaMirrors.scala:1121)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$FromJavaClassCompleter$$anonfun$completeRest$1$$anonfun$apply$mcV$sp$1$$anonfun$apply$mcV$sp$3.apply(JavaMirrors.scala:776)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$FromJavaClassCompleter$$anonfun$completeRest$1$$anonfun$apply$mcV$sp$1$$anonfun$apply$mcV$sp$3.apply(JavaMirrors.scala:776)
        at scala.collection.IndexedSeqOptimized$class.foreach(IndexedSeqOptimized.scala:33)
        at scala.collection.mutable.ArrayOps$ofRef.foreach(ArrayOps.scala:186)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$FromJavaClassCompleter$$anonfun$completeRest$1$$anonfun$apply$mcV$sp$1.apply$mcV$sp(JavaMirrors.scala:776)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$FromJavaClassCompleter$$anonfun$completeRest$1.apply$mcV$sp(JavaMirrors.scala:786)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$FromJavaClassCompleter$$anonfun$completeRest$1.apply(JavaMirrors.scala:745)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$FromJavaClassCompleter$$anonfun$completeRest$1.apply(JavaMirrors.scala:745)
        at scala.reflect.runtime.Gil$class.gilSynchronized(Gil.scala:19)
        at scala.reflect.runtime.JavaUniverse.gilSynchronized(JavaUniverse.scala:16)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$FromJavaClassCompleter.completeRest(JavaMirrors.scala:745)
        at scala.reflect.runtime.JavaMirrors$JavaMirror$FromJavaClassCompleter$LazyPolyType.complete(JavaMirrors.scala:793)
        at scala.reflect.internal.Symbols$Symbol.info(Symbols.scala:1483)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anon$8.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info(SynchronizedSymbols.scala:168)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anonfun$info$1.apply(SynchronizedSymbols.scala:127)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anonfun$info$1.apply(SynchronizedSymbols.scala:127)
        at scala.reflect.runtime.Gil$class.gilSynchronized(Gil.scala:19)
        at scala.reflect.runtime.JavaUniverse.gilSynchronized(JavaUniverse.scala:16)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$class.gilSynchronizedIfNotThreadsafe(SynchronizedSymbols.scala:123)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anon$8.gilSynchronizedIfNotThreadsafe(SynchronizedSymbols.scala:168)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$class.info(SynchronizedSymbols.scala:127)
        at scala.reflect.runtime.SynchronizedSymbols$SynchronizedSymbol$$anon$8.info(SynchronizedSymbols.scala:168)
        at scala.reflect.internal.Symbols$Symbol.baseTypeSeqLength$1(Symbols.scala:1842)
        at scala.reflect.internal.Symbols$Symbol.isLess(Symbols.scala:1845)
        at scala.reflect.internal.Types$Type.baseTypeIndex(Types.scala:898)
        at scala.reflect.internal.Types$CompoundType.baseType(Types.scala:1401)
        at scala.reflect.internal.Types$ClassTypeRef$class.baseType(Types.scala:1968)
        at scala.reflect.internal.Types$ClassNoArgsTypeRef.baseType(Types.scala:2331)
        at scala.reflect.internal.tpe.TypeComparers$class.firstTry$1(TypeComparers.scala:405)
        at scala.reflect.internal.tpe.TypeComparers$class.isSubType2(TypeComparers.scala:552)
        at scala.reflect.internal.tpe.TypeComparers$class.isSubType1(TypeComparers.scala:320)
        at scala.reflect.internal.tpe.TypeComparers$class.isSubType(TypeComparers.scala:278)
        at scala.reflect.internal.SymbolTable.isSubType(SymbolTable.scala:16)
        at scala.reflect.internal.Types$Type.$less$colon$less(Types.scala:779)
        at scala.reflect.internal.Types$Type.$less$colon$less(Types.scala:260)
        at ErrorTest$.delayedEndpoint$ErrorTest$1(ErrorTest.scala:16)
        at ErrorTest$delayedInit$body.apply(ErrorTest.scala:6)
        at scala.Function0$class.apply$mcV$sp(Function0.scala:40)
        at scala.runtime.AbstractFunction0.apply$mcV$sp(AbstractFunction0.scala:12)
        at scala.App$$anonfun$main$1.apply(App.scala:76)
        at scala.App$$anonfun$main$1.apply(App.scala:76)
        at scala.collection.immutable.List.foreach(List.scala:381)
        at scala.collection.generic.TraversableForwarder$class.foreach(TraversableForwarder.scala:35)
        at scala.App$class.main(App.scala:76)
        at ErrorTest$.main(ErrorTest.scala:6)
        at ErrorTest.main(ErrorTest.scala)
```