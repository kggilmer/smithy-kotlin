# Changelog

## [v0.4.0-alpha](https://gitlab.com/html-validate/html-validate/compare/v0.4.0-alpha) (2021-08-26)

### Features

 -  General presigner support (#439) ([bd016aea94abafa](https://gitlab.com/html-validate/html-validate/commit/bd016aea94abafa48a977c1574398e04384144db))
 -  **codegen**  Detect and fail if base exception collides with modeled exception (#448) ([00603074e363503](https://gitlab.com/html-validate/html-validate/commit/00603074e3635033580712f89072643ec3ffa837))
 -  support httpChecksumRequired trait (#447) ([0747fb7434974f8](https://gitlab.com/html-validate/html-validate/commit/0747fb7434974f810e31347716eb98768297659e))
 -  enable signing for published artifacts (#444) ([18bee86c3f9952e](https://gitlab.com/html-validate/html-validate/commit/18bee86c3f9952eebb87f4d850a6f410825a6a2c))
 -  **rt**  jvm sha256, md5, and crc32 hash functions (#440) ([288a4a0eaae3322](https://gitlab.com/html-validate/html-validate/commit/288a4a0eaae3322b6aacc5bdb9a32da8b45e7828))
 -  provide opt-in wire logging (#425) ([dc4e5949342157d](https://gitlab.com/html-validate/html-validate/commit/dc4e5949342157d0a598f076152d5eab2052e1af))
 -  **codegen**  KotlinIntegrations able to provide section writers ([f22547b322a9e12](https://gitlab.com/html-validate/html-validate/commit/f22547b322a9e12d3e1d5552bf788f3cdc374403))
 -  **rt**  use UUIDs for idempotency tokens (#419) ([e7d35ead6a24c77](https://gitlab.com/html-validate/html-validate/commit/e7d35ead6a24c7756915a75fac5805e1c71d98fc))

### Bug Fixes

 -  query value can have equals sign (#459) ([659a6c3b0a7656c](https://gitlab.com/html-validate/html-validate/commit/659a6c3b0a7656cf823989b9dae023a78b1a3072))
 -  **codegen**  fix toString member name representations (#453) ([284ea63cb9d0b5b](https://gitlab.com/html-validate/html-validate/commit/284ea63cb9d0b5bc2278b6a6aa49381fa60d7883))
 -  **codegen**  track dependencies as a set (rather than list) (#454) ([0469e1a9f4cc694](https://gitlab.com/html-validate/html-validate/commit/0469e1a9f4cc6949049932abeec2bac9a0f176a0))
 -  enhance @Sensitive toString() test (#445) ([23783b8f13d17d5](https://gitlab.com/html-validate/html-validate/commit/23783b8f13d17d59424387207f80630908d2714c))
 -  sanitize sdkId from settings to strip API|Client|Service suffixes (#442) ([abf7ca665d93dcd](https://gitlab.com/html-validate/html-validate/commit/abf7ca665d93dcdededf09620f4b45f58c60df42))
 -  only override content-type if not already set (#443) ([4034fad2802c932](https://gitlab.com/html-validate/html-validate/commit/4034fad2802c932e1c0995d502c9900a89b9d9d7))
 -  httpRequestTest with streaming member compile error (#424) ([6045628f536e483](https://gitlab.com/html-validate/html-validate/commit/6045628f536e483e65a29b497cf4f95b3b274586))

## [v0.3.0-M2](https://gitlab.com/html-validate/html-validate/compare/v0.3.0-M2) (2021-06-18)

### Features

 -  add support for aliases in XML deserializer (#402) ([eee87f8b0ecbbda](https://gitlab.com/html-validate/html-validate/commit/eee87f8b0ecbbda19fa729d87293664565b15fed))
 -  add missing IO primitives and manage HTTP engine explicitly (#381) ([3f0f5ba98c477ec](https://gitlab.com/html-validate/html-validate/commit/3f0f5ba98c477ecfa0415368ff531bb3f7da4bbc))
 -  **codegen**  Additions to KotlinIntegration for fine-grained codegen customization (#383) ([096c05755367a7d](https://gitlab.com/html-validate/html-validate/commit/096c05755367a7d08947731d3f2b8a0ff1a21795))
 -  aws query protocol (#351) ([58c5d6f2c12e88a](https://gitlab.com/html-validate/html-validate/commit/58c5d6f2c12e88a6014ae61de98f4c2f54fa77a8))
 -  **codegen**  change operation dsl methods to overloads from extensions (#345) ([65243779b989346](https://gitlab.com/html-validate/html-validate/commit/65243779b9893467232bf88936c530ed06699046))

### Bug Fixes

 -  **serde**  nested form-url struct with list or map serialization (#407) ([cbe3b278d77ec2d](https://gitlab.com/html-validate/html-validate/commit/cbe3b278d77ec2dd1ec65d32399b7c3f72855f15))
 -  **rt**  explicitly specify UTF-8 encoding for XML serializer (#406) ([73e7b9f5a1200d0](https://gitlab.com/html-validate/html-validate/commit/73e7b9f5a1200d045ead0f252591a73476a5a9bb))
 -  escape brackets in documentation traits (#401) ([87cfa07dcf3163c](https://gitlab.com/html-validate/html-validate/commit/87cfa07dcf3163c1fa364d2bd2df1d41cd8560cf))
 -  **rt**  xml parse issues with some characters (#398) ([6cac6d2e62be3b9](https://gitlab.com/html-validate/html-validate/commit/6cac6d2e62be3b9c14487caad97359a08d291a5a))
 -  detect idempotency tokens on operations via resource (#394) ([4349affed261d48](https://gitlab.com/html-validate/html-validate/commit/4349affed261d488e9a2ff96c9ebf326da7bcc0d))
 -  uri literals with dollar sign not escaped correctly (#396) ([7ca895669619be8](https://gitlab.com/html-validate/html-validate/commit/7ca895669619be8f91aaaa8b1e90ec5941d3bfeb))
 -  **codegen**  undo exception renaming (#393) ([127315cc7e2d8e3](https://gitlab.com/html-validate/html-validate/commit/127315cc7e2d8e3da49bbd6b3300d842e751000f))
 -  ensure ByteStream is completely consumed (#388) ([3a33d01ef155fd4](https://gitlab.com/html-validate/html-validate/commit/3a33d01ef155fd4fe66b6c11931e06a601eb395e))
 -  **rt**  reserve behavior with existing data; add new convenience wrappers (#377) ([f8600b2cfef259f](https://gitlab.com/html-validate/html-validate/commit/f8600b2cfef259fbc13b9b5d09d7e16055de5d42))
 -  explicitly encode httpLabel bound members (#364) ([a54de824ed3a17c](https://gitlab.com/html-validate/html-validate/commit/a54de824ed3a17cbf2824b3dcee8c8c18cdd523e))
 -  **rt**  Escape end of line characters based on 'XML End-Of-Line Encoding' (#349) ([86756ccebe64565](https://gitlab.com/html-validate/html-validate/commit/86756ccebe64565da7278bab21abfb51a9f3238f))

## [v0.2.0-M1](https://gitlab.com/html-validate/html-validate/compare/v0.2.0-M1) (2021-05-10)

### Features

 -  **codegen**  add operation dsl overloads (#321) ([46ca71bbd275ce5](https://gitlab.com/html-validate/html-validate/commit/46ca71bbd275ce5d2de52a13818df811a225c4e3))
 -  **codegen**  suffix exception names where appropriate (#313) ([4b22b88089ff7d9](https://gitlab.com/html-validate/html-validate/commit/4b22b88089ff7d9d87a82e73435339c82ffea04a))
 -  add @Deprecated annotations to applicable declarations (#311) ([3ce1c87d85b690a](https://gitlab.com/html-validate/html-validate/commit/3ce1c87d85b690ad561a11c252de7ffe599ccea2))
 -  **codegen**  allow integrations to customize the middleware stack (#286) ([132a973d317f378](https://gitlab.com/html-validate/html-validate/commit/132a973d317f3788ce47c26540a04f9b13137d38))
 -  restXml (#279) ([88b01fb699fc109](https://gitlab.com/html-validate/html-validate/commit/88b01fb699fc109325ed60a62a5a1bd627cf404c))
 -  **io**  implement missing IO runtime primitives (#264) ([b083bd97ea8e326](https://gitlab.com/html-validate/html-validate/commit/b083bd97ea8e326a6da6c8ff44fd9cf309f4918a))

### Bug Fixes

 -  unify serde exceptions (#315) ([365e993b9b06b16](https://gitlab.com/html-validate/html-validate/commit/365e993b9b06b167b5f5192587608f63d20de8b2))
 -  make config builder names match structure builders (#307) ([223b4ca79e7b2af](https://gitlab.com/html-validate/html-validate/commit/223b4ca79e7b2af12137b49bcdfab4dc8010d933))
 -  allow writing to file that doesn't exist yet (#298) ([83e6530394fc007](https://gitlab.com/html-validate/html-validate/commit/83e6530394fc007224a434b7d8f90fc4e32d99eb))
 -  **rt**  print Instant in ISO 8601 format (#291) ([fdf5f8f1c32408c](https://gitlab.com/html-validate/html-validate/commit/fdf5f8f1c32408c3c5a08f7e54fa2fe203da328f))
 -  do not validate root elements and fix flat struct list deserialization (#289) ([d690a2c486a946e](https://gitlab.com/html-validate/html-validate/commit/d690a2c486a946e6ea1d09b79a086ccdbcb49da7))
 -  turn off default ktor response validation (#280) ([174068456ab8990](https://gitlab.com/html-validate/html-validate/commit/174068456ab8990c189b6796697108f196fa9bed))
 -  **rt**  use sdkId if available for service client generation (#276) ([0b87b84358da8f8](https://gitlab.com/html-validate/html-validate/commit/0b87b84358da8f893dcc37f3287df48aa2b0c085))

## [v0.1.0-M0](https://gitlab.com/html-validate/html-validate/compare/v0.1.0-M0) (2021-03-18)


### Bug Fixes

 -  generate member documentation on builder interfaces (#252) ([f8ff1fb5b047f2b](https://gitlab.com/html-validate/html-validate/commit/f8ff1fb5b047f2b1317dbeaee7b772ac02ae12f5))

## [v0.1.0](https://gitlab.com/html-validate/html-validate/compare/v0.1.0) (2021-03-16)

### Features

 -  platform detection and utils (#246) ([7a21bbc353154c3](https://gitlab.com/html-validate/html-validate/commit/7a21bbc353154c33005294f8b1aa66bee8a9225a))
 -  **codegen**  normalize operations (#74) ([98a8b68ce9a3ed5](https://gitlab.com/html-validate/html-validate/commit/98a8b68ce9a3ed5f00423b4d259e1563df02652c))
 -  support endpointTrait hostPrefix (#53) ([139ca6c07cad20d](https://gitlab.com/html-validate/html-validate/commit/139ca6c07cad20df2d857c5fc7a95cf75191bd70))
 -  Implement reading of sdkId from smithy-build.json and using that to generate client name. (#43) ([b8baf23dab5f73a](https://gitlab.com/html-validate/html-validate/commit/b8baf23dab5f73a14062193ee51348090e0bd75b))
 -  **codegen**  awsJson 1.0 protocol test compliance (#32) ([05acaf0183a64cf](https://gitlab.com/html-validate/html-validate/commit/05acaf0183a64cf6c949ff620f9f7e4951bab6b8))
 -  **rt**  add a logging interface (#30) ([12b208e92c0816a](https://gitlab.com/html-validate/html-validate/commit/12b208e92c0816a2c3e5d2d8e397f5c3beacd701))
 -  **rt**  add support for formatting Instant as epoch milliseconds ([b454b257e691784](https://gitlab.com/html-validate/html-validate/commit/b454b257e691784de0e0813f4e2663b0825a23cc))
 -  **codegen**  Add tests for model evolution (#22) ([decb1ed5366f1eb](https://gitlab.com/html-validate/html-validate/commit/decb1ed5366f1ebb90ad4b0ec46587fa09b5c52e))
 -  **rt**  Add support for nested (in-line) collection serialization ([a7f0629f99a25f2](https://gitlab.com/html-validate/html-validate/commit/a7f0629f99a25f21d501aeebf4f30a8898c103d1))
 -  Service client config ([145be958f2ba8b2](https://gitlab.com/html-validate/html-validate/commit/145be958f2ba8b26000e31552ab2967221ffa3c0))
 -  **codegen**  Union types ([8fe8828d69d14a4](https://gitlab.com/html-validate/html-validate/commit/8fe8828d69d14a41529249b3679d0bdab31695c1))
 -  **codegen**  generate error response tests ([f5cf8413f6b8ffd](https://gitlab.com/html-validate/html-validate/commit/f5cf8413f6b8ffd736532118ef1c29410df28d20))
 -  **rt**  generate httpResponseTest unit tests ([2ba4bb044ddb749](https://gitlab.com/html-validate/html-validate/commit/2ba4bb044ddb7496d4c44e3f3f12ba6653e570c4))
 -  **codegen**  bootstrap generation of httpRequestTest generation for restJson1 protocol ([23178b31bd47cab](https://gitlab.com/html-validate/html-validate/commit/23178b31bd47cab6995eaaee58ba85d265c0cc31))
 -  **codegen**  generate deserializers for HTTTP responses ([013249311dc7f37](https://gitlab.com/html-validate/html-validate/commit/013249311dc7f3781d57f94b395ae8bcea2965f4))
 -  **rt**  add missing converstion to double for Instant ([c3b1979f1902b0d](https://gitlab.com/html-validate/html-validate/commit/c3b1979f1902b0d9e1542405364097ca5341b76b))
 -  **rt**  implement Kotlin MPP compatible base64 utilities (#40) ([9ca4f780c545b38](https://gitlab.com/html-validate/html-validate/commit/9ca4f780c545b38803a45e3895a52b32aafa1908))
 -  **codegen**  initial integration and protocol generator bootstrap ([864d38a13e82410](https://gitlab.com/html-validate/html-validate/commit/864d38a13e8241035b3dbf7c0c61a58c97ee2b25))
 -  **codegen**  generate timestamp shapes ([73b6ad326514fb6](https://gitlab.com/html-validate/html-validate/commit/73b6ad326514fb6b865ca1a4f71fbc35993d44bc))
 -  **rt**  XML de/serialization implementation ([48f12ed02c5e5da](https://gitlab.com/html-validate/html-validate/commit/48f12ed02c5e5dab5d98088d13dc67ded7381a05))
 -  smithy httpRequestTest support lib (#32) ([e995fadb2029e36](https://gitlab.com/html-validate/html-validate/commit/e995fadb2029e36eed0e9b469c3d5fb71d8108dd))
 -  **rt**  add support for parsing and formatting timestamps ([9d4ced40e680e74](https://gitlab.com/html-validate/html-validate/commit/9d4ced40e680e749c867010baee0fe5ff162c838))
 -  **codegen**  generate service interface (#27) ([553446454b7df8d](https://gitlab.com/html-validate/html-validate/commit/553446454b7df8d01d35acb8b39df53188e12064))
 -  **rt**  add initial support for streaming HTTP request/response bodies (#19) ([f501953b28f1218](https://gitlab.com/html-validate/html-validate/commit/f501953b28f1218d589a05761a57c260d5720643))
 -  **rt**  generic deserializer interface and JSON Implementation (#21) ([dcadfefaeea9d7b](https://gitlab.com/html-validate/html-validate/commit/dcadfefaeea9d7bf62a0ef17a8a27e7234b8b3e5))
 -  **rt**  add JsonStreamWriter interface and implementation based on Gson (#17) ([22e5fc6e3ef07a5](https://gitlab.com/html-validate/html-validate/commit/22e5fc6e3ef07a5783cfaaa4fddd0720d4e592dd))
 -  **serde**  define common serializer interface and JSON implementation (#18) ([15e269aa946b94b](https://gitlab.com/html-validate/html-validate/commit/15e269aa946b94b2c3555eb4dfaf2e1d5b507a35))
 -  **codegen**  implement documentation support (#12) ([986f97c6bb52494](https://gitlab.com/html-validate/html-validate/commit/986f97c6bb524940ed7e5f5ae8de2ff4152719a9))
 -  **rt**  introduce InternalAPI annotation ([784b2286374113a](https://gitlab.com/html-validate/html-validate/commit/784b2286374113afa02cb476d21dea7058e8ac50))
 -  **codegen**  add enum support to structure generation and fix copy() implementation ([5817875c4afea8b](https://gitlab.com/html-validate/html-validate/commit/5817875c4afea8bee5ce23c590245c527ab3892b))
 -  **rt**  add core HTTP primitives (#16) ([46b3189d2a0d59a](https://gitlab.com/html-validate/html-validate/commit/46b3189d2a0d59a46396f7927879c7c4b8ffed65))
 -  **codegen**  implement structure generation as immutable classes ([07c16778b7c04f9](https://gitlab.com/html-validate/html-validate/commit/07c16778b7c04f9904b27b4b4e0c053281566b09))
 -  **codegen**  implement enum generation ([a297fb3e611a76c](https://gitlab.com/html-validate/html-validate/commit/a297fb3e611a76cf76a7bd810a30895a4c4a3e84))
 -  **codegen**  add imports for symbols in a different namespace ([8b79479a9511a02](https://gitlab.com/html-validate/html-validate/commit/8b79479a9511a0245ab2cc7f7ae4d30ac263c504))
 -  **codegen**  implement union generation (#9) ([51f5d593459f17b](https://gitlab.com/html-validate/html-validate/commit/51f5d593459f17b2202938bc572ea3d3776b80ea))

### Bug Fixes

 -  percent encode valid pchar ':' to fix signature mismatches (#244) ([ea49c3208cf157d](https://gitlab.com/html-validate/html-validate/commit/ea49c3208cf157d5723c79d9a7cd9542b389dad0))
 -  generate union deserializers that drive field iteration to exhaustion to maintain proper state (#231) ([abc05bb1f0c0e2e](https://gitlab.com/html-validate/html-validate/commit/abc05bb1f0c0e2e4f5d50763f0d4584f86e1737e))
 -  **codegen**  invalid codegen of nested union members (#73) ([ac7b1a36243df94](https://gitlab.com/html-validate/html-validate/commit/ac7b1a36243df94bb56046a8d81f9a569923a336))
 -  **codegen**  handling package namespace validation ([724b7871b92d2a8](https://gitlab.com/html-validate/html-validate/commit/724b7871b92d2a869ea28c034eeb472297c6effb))
 -  **codegen**  escape struct members that are also Kotlin keywords.   (#68) ([0f855ed17af9a5e](https://gitlab.com/html-validate/html-validate/commit/0f855ed17af9a5e8533820e32a7c15c6ea28ed9b))
 -  Update readme w/ module and first stab at defining where shared logic should live in the source tree. (#67) ([376db358c0ee9da](https://gitlab.com/html-validate/html-validate/commit/376db358c0ee9daa84d47d5e34242c48fa145228))
 -  **codegen**  interpolated string encoding error in url path builder (#65) ([c652ee5d4bc846f](https://gitlab.com/html-validate/html-validate/commit/c652ee5d4bc846f8b1e7bdc1319ebde30327c258))
 -  **codegen**  sanitize docs (#61) ([92c355d4e82cdb7](https://gitlab.com/html-validate/html-validate/commit/92c355d4e82cdb712e9ddb75795c70e1b33b96fc))
 -  **codegen**  handle unboxed primitives serde (#62) ([5c3c58ce57b8e9f](https://gitlab.com/html-validate/html-validate/commit/5c3c58ce57b8e9f7f6418721025bf417322c7a9f))
 -  rename shapes that conflict with kotlin builtin types for better… (#59) ([84bed556c157c9c](https://gitlab.com/html-validate/html-validate/commit/84bed556c157c9c0927dcecd0b515d4358cd4acc))
 -  use fully qualified names for builtins and sealed classes ([6c59ab261990d41](https://gitlab.com/html-validate/html-validate/commit/6c59ab261990d4133533e174bf4e2a6928b66a53))
 -  generate union sdkunknown type to handle deserialization backcompat (#56) ([93cda51c77b85a2](https://gitlab.com/html-validate/html-validate/commit/93cda51c77b85a26ba8380d969d638de953fbbb1))
 -  set content-type header more carefully to prevent signing issues (#55) ([d094028d70f96a3](https://gitlab.com/html-validate/html-validate/commit/d094028d70f96a39861574dfcd55651f388f48dc))
 -  add encodedPath to UrlBuilder and only build URL once (#54) ([86373ab2b31d315](https://gitlab.com/html-validate/html-validate/commit/86373ab2b31d31511415c3fe3a327fabc9f73e38))
 -  **codegen**  use member shape to test for list and map values with t… (#49) ([3979078dba5fbae](https://gitlab.com/html-validate/html-validate/commit/3979078dba5fbae0037a63da3e4410d85acb3418))
 -  **codegen**  collection name in serializer (#48) ([f5725bf916b4633](https://gitlab.com/html-validate/html-validate/commit/f5725bf916b4633a0c66032dffbd30c213344031))
 -  **codegen**  nested union deserialization (#47) ([d249f7392372dc3](https://gitlab.com/html-validate/html-validate/commit/d249f7392372dc364bb3014ba103f9dfd54f0260))
 -  Rename primitive deserializer methods to match Kotlin types (#45) ([75f1e3b10089878](https://gitlab.com/html-validate/html-validate/commit/75f1e3b10089878432a6045371666fa6b3c0251c))
 -  misc serialization codegen (#44) ([98133f52a289aaa](https://gitlab.com/html-validate/html-validate/commit/98133f52a289aaa8ecf11f7f4d0afb1e9495006f))
 -  **codegen**  use fully qualified symbol name to prevent conflicts with model enums with same name ([3b0f34e4b9c7468](https://gitlab.com/html-validate/html-validate/commit/3b0f34e4b9c746881e4f867b6f3b313f3029978e))
 -  **rt**  parse fractional seconds for http-dates (rfc5322) ([31ab0773d3fbf9e](https://gitlab.com/html-validate/html-validate/commit/31ab0773d3fbf9e8c565350ca33813706404f7e4))
 -  **codegen**  nested map serialization (#36) ([709018197b699e0](https://gitlab.com/html-validate/html-validate/commit/709018197b699e0be837b59a233d88def188e9b2))
 -  **rt**  bandaid DefaultRequest middleware to not override HttpRequestBuilder() properties set when explicitly given to an SdkHttpClient ([617a7799d6e487c](https://gitlab.com/html-validate/html-validate/commit/617a7799d6e487c9b4d243b25368444f64defe04))
 -  codegen optionally generates idempotency config but to use HttpSerde feature requires it to be set; default it instead if not provided ([57a258cb02bc435](https://gitlab.com/html-validate/html-validate/commit/57a258cb02bc435fff7dd8e79dbe1e72127fede9))
 -  **serde**  do not enumerate explicitly null JSON fields ([18344bbdeef677d](https://gitlab.com/html-validate/html-validate/commit/18344bbdeef677d6fdccfef413d1eae0ed2c9635))
 -  deal with setting content-type header more explicitly ([07f6d514a092bef](https://gitlab.com/html-validate/html-validate/commit/07f6d514a092bef230c4ce4ffb6ab123c4b78bf7))
 -  missed changing test result collection for some integration tests (#26) ([80638a03e254d04](https://gitlab.com/html-validate/html-validate/commit/80638a03e254d0404ad2c86d91a41d4de8fb06d3))
 -  **rt**  Fix junit test execution that regressed from earlier junit5 upgrade PR. (#23) ([8bfebd62fa616bd](https://gitlab.com/html-validate/html-validate/commit/8bfebd62fa616bdde0628e0e6237b509e3b9bc7b))
 -  **codegen**  map of collection serde (#16) ([f70fba865ada6ca](https://gitlab.com/html-validate/html-validate/commit/f70fba865ada6ca7580e79fa1feec7defbada30b))
 -  Codegen fixes ([5db8df1d27cd581](https://gitlab.com/html-validate/html-validate/commit/5db8df1d27cd581bf6f00f11ac93a74b75127797))
 -  **rt**  Flatten lists and maps with null values support in Xml Deserializer ([80c68fa30ac9f51](https://gitlab.com/html-validate/html-validate/commit/80c68fa30ac9f51d1708a5fb8e6091d6b3237c6f))
 -  allow serialization and deserialization of null values ([ec72c78dc0fb3a9](https://gitlab.com/html-validate/html-validate/commit/ec72c78dc0fb3a9b4a7182e371a37b5513801128))
 -  bad rebase/merge. serde interfaces changed ([b9f4d3e9bf3dded](https://gitlab.com/html-validate/html-validate/commit/b9f4d3e9bf3dded101c86ef9e600ddbb15123318))
 -  **codegen**  special case hashCode() and equals() implementations to deal with ByteArray members ([e78a5e9a067badc](https://gitlab.com/html-validate/html-validate/commit/e78a5e9a067badcc06685515ad2d951fdca71e1d))
 -  **codegen**  render HttpDeserialize for generated exceptions ([ccf7fd6922934b4](https://gitlab.com/html-validate/html-validate/commit/ccf7fd6922934b47a2250478dd0053ea35a83fc1))
 -  **rt**  add override to smithy-test package to compare ByteArray contents ([b851ab7031ca1f8](https://gitlab.com/html-validate/html-validate/commit/b851ab7031ca1f8805f7b31fb0592f7f85a57c58))
 -  **codegen**  fix how list bound header members are deserialized ([4ba162ff0ca29a8](https://gitlab.com/html-validate/html-validate/commit/4ba162ff0ca29a839715ea422197513c60cfe4b2))
 -  **rt**  fix equals() override for Instant ([329c2f3126c45ed](https://gitlab.com/html-validate/html-validate/commit/329c2f3126c45ed58cc41270efda3480bc4f7d2a))
 -  **rt**  split httpResponseTest headers ([61d60b27c7d998a](https://gitlab.com/html-validate/html-validate/commit/61d60b27c7d998ad6be254fa91c6d24625ce13b3))
 -  **codegen**  deserialize map keys before the associated value ([5c5f62b70fa1918](https://gitlab.com/html-validate/html-validate/commit/5c5f62b70fa19188ccee5102b134c6232da970af))
 -  **serde**  allow tokens to be consumed liberally as String when deserializing ([411da04961a0a33](https://gitlab.com/html-validate/html-validate/commit/411da04961a0a33507e3b68e6c82bdfe04602b9e))
 -  **codegen**  generate union shapes in sorted order ([34de9b349f5fa80](https://gitlab.com/html-validate/html-validate/commit/34de9b349f5fa80e494aa8bde72eaadf7f8872b7))
 -  **codegen**  close() method is overriden in the actual service client not the interface ([c7fa1032398cc61](https://gitlab.com/html-validate/html-validate/commit/c7fa1032398cc61f4b189584fd1559abb4a08cab))
 -  **codegen**  prefix generated enum names when values are invalid Kotlin identifiers (#33) ([88248cc944f824e](https://gitlab.com/html-validate/html-validate/commit/88248cc944f824e05309ecfd801dbc5beaf66404))
 -  **codegen**  escape reserved words with backticks instead of prefixing with underscore ([0e9a6547ea93fbc](https://gitlab.com/html-validate/html-validate/commit/0e9a6547ea93fbc6ea41a276c15d5ca7acef78bd))
 -  import POC efforts and restructure the design example into multiple projects ([336f791507d456e](https://gitlab.com/html-validate/html-validate/commit/336f791507d456ea84d211f90b5656858dd4d8b8))

