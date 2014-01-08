
#import <Foundation/Foundation.h>
//*/* 表名 sys_parameter /*/*//
@interface SysParameter :NSObject
 		////类型 java.lang.Long  说明 id 字段名 ID 
		@property (nonatomic, strong) NSNumber ////id;
 	
 	
 	
 

 		////类型 java.lang.String  说明 参数名称 字段名 PAR_NAME 
 	
		@property (nonatomic, strong) NSString ////parName;
 	
 	
 

 		////类型 java.lang.String  说明 参数代码 字段名 PAR_CODE 
 	
		@property (nonatomic, strong) NSString ////parCode;
 	
 	
 

 		////类型 java.lang.Long  说明 上级参数 字段名 PAR_UP_ID 
		@property (nonatomic, strong) NSNumber ////parUpId;
 	
 	
 	
 

@end
