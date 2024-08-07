// 定义命名空间
namespace java com.example.project
namespace py example.project

// 引入其他 Thrift 文件
include "shared.thrift"

// 定义常量
const i32 DEFAULT_AGE = 25
const string DEFAULT_NAME = "Anonymous"
const double PI = 3.14159

// 定义枚举
enum Gender {
  MALE = 0,
  FEMALE = 1,
  OTHER = 2
}

// 定义结构体
struct Person {
  1: required string name = "John Doe", // 默认值
  2: optional i32 age = DEFAULT_AGE, // 使用常量
  3: required Gender gender,
  4: optional list<string> hobbies,
  5: map<string, string> attributes,
  6: Container nestedContainer // 嵌套类型
}

// 定义联合体
union ExampleUnion {
  1: i32 intValue,
  2: string stringValue,
  3: bool boolValue
}

// 定义异常
exception InvalidOperation {
  1: i32 code,
  2: string message
}

// 定义服务
service PersonService {
  Person getPersonByName(1: string name) throws (1: InvalidOperation io),
  list<Person> getAllPersons(),
  void savePerson(1: Person person) throws (1: InvalidOperation io),
  oneway void ping(),
  bool checkPersonExists(1: string name) // 返回布尔值的方法
}

// 定义类型别名
typedef i64 Timestamp

// 定义容器
struct Container {
  1: list<i32> numbers,
  2: set<string> uniqueStrings,
  3: map<string, i32> nameToId
}

// 定义空结构体
struct EmptyStruct {}

// 单行注释

/*
  多行注释
*/

// 包含所有基本类型和复杂类型的结构体
struct AllTypes {
  1: bool aBool,
  2: byte aByte,
  3: i16 aI16,
  4: i32 aI32,
  5: i64 aI64,
  6: double aDouble,
  7: string aString,
  8: binary aBinary, // binary 类型
  9: list<string> aList,
  10: set<i32> aSet,
  11: map<string, i32> aMap,
  12: ExampleUnion aUnion
}

// 示例中的共享文件内容 (shared.thrift)
namespace java com.example.shared

typedef string UUID
const UUID DEFAULT_UUID = "00000000-0000-0000-0000-000000000000"

// 服务方法中使用异步 (future) 语法
service SharedService {
  bool checkUUID(1: UUID uuid)
}
