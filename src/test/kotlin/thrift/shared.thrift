// 示例中的共享文件内容 (shared.thrift)
namespace java com.example.shared

typedef string UUID
const UUID DEFAULT_UUID = "00000000-0000-0000-0000-000000000000"

// 服务方法中使用异步 (future) 语法
service SharedService {
  bool checkUUID(1: UUID uuid)
}