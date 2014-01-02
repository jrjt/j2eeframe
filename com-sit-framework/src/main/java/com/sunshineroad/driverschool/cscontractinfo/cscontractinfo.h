
#import <Foundation/Foundation.h>
//*/* 表名 cs_contract_info /*/*//
@interface CsContractInfo :NSObject
 		////类型 java.lang.Long  说明 id 字段名 ID 
		@property (nonatomic, strong) NSNumber ////id;
 	
 	
 	
 

 		////类型 java.lang.String  说明 数据项含义 字段名 AREA 
 	
		@property (nonatomic, strong) NSString ////area;
 	
 	
 

 		////类型 java.lang.String  说明 区域 字段名 CUSTOMER_NAME 
 	
		@property (nonatomic, strong) NSString ////customerName;
 	
 	
 

 		////类型 java.lang.String  说明 客户名称 字段名 CUSTOMER_TYPE 
 	
		@property (nonatomic, strong) NSString ////customerType;
 	
 	
 

 		////类型 java.lang.String  说明 客户类型 字段名 CONTRACT_NUMBER 
 	
		@property (nonatomic, strong) NSString ////contractNumber;
 	
 	
 

 		////类型 java.lang.String  说明 合同编号/销单编号/签证编号 字段名 CONTRACT_NAME 
 	
		@property (nonatomic, strong) NSString ////contractName;
 	
 	
 

 		////类型 java.lang.String  说明 合同名称 字段名 CONTRACT_TYPE 
 	
		@property (nonatomic, strong) NSString ////contractType;
 	
 	
 

 		////类型 java.lang.String  说明 合同类型 字段名 PROJECT_NUMBER 
 	
		@property (nonatomic, strong) NSString ////projectNumber;
 	
 	
 

 		////类型 java.util.Date  说明 项目编号 字段名 SIGN_DATE 
 	
 	
		@property (nonatomic, strong) NSDate ////signDate;
 	
 

 		////类型 java.util.Date  说明 签订时间 字段名 END_DATE 
 	
 	
		@property (nonatomic, strong) NSDate ////endDate;
 	
 

 		////类型 java.math.BigDecimal  说明 到期时间 字段名 CONTRACT_MONEY 
 	
 	
 	
 

 		////类型 java.math.BigDecimal  说明 合同额 字段名 SETTLEMENT_MONEY 
 	
 	
 	
 

 		////类型 java.lang.String  说明 结算凭证金额 字段名 PROJECT_INFO 
 	
		@property (nonatomic, strong) NSString ////projectInfo;
 	
 	
 

 		////类型 java.math.BigDecimal  说明 是否立项 字段名 FIRST_PAYMONEY 
 	
 	
 	
 

 		////类型 java.util.Date  说明 首付款金额 字段名 FIRST_PAYMONEY_DATE 
 	
 	
		@property (nonatomic, strong) NSDate ////firstPaymoneyDate;
 	
 

 		////类型 java.math.BigDecimal  说明 首付款回款时间 字段名 SECOND_PAYMONEY 
 	
 	
 	
 

 		////类型 java.util.Date  说明 第二笔金额 字段名 SECOND_PAYMONEY_DATE 
 	
 	
		@property (nonatomic, strong) NSDate ////secondPaymoneyDate;
 	
 

 		////类型 java.math.BigDecimal  说明 第二笔回款时间 字段名 END_PAYMONEY 
 	
 	
 	
 

 		////类型 java.util.Date  说明 尾款金额 字段名 END_PAYMONEY_DATE 
 	
 	
		@property (nonatomic, strong) NSDate ////endPaymoneyDate;
 	
 

 		////类型 java.math.BigDecimal  说明 尾款回款时间 字段名 OTHER_PAYMONEY 
 	
 	
 	
 

 		////类型 java.util.Date  说明 其他回款金额 字段名 OTHER_PAYMONEY_DATE 
 	
 	
		@property (nonatomic, strong) NSDate ////otherPaymoneyDate;
 	
 

 		////类型 java.lang.String  说明 备用字段1 字段名 REMARK1 
 	
		@property (nonatomic, strong) NSString ////remark1;
 	
 	
 

 		////类型 java.lang.String  说明 备用字段2 字段名 REMARK2 
 	
		@property (nonatomic, strong) NSString ////remark2;
 	
 	
 

 		////类型 java.lang.String  说明 备用字段3 字段名 REMARK3 
 	
		@property (nonatomic, strong) NSString ////remark3;
 	
 	
 

 		////类型 java.lang.String  说明 备用字段4 字段名 REMARK4 
 	
		@property (nonatomic, strong) NSString ////remark4;
 	
 	
 

 		////类型 java.lang.String  说明 备用字段5 字段名 REMARK5 
 	
		@property (nonatomic, strong) NSString ////remark5;
 	
 	
 

@end
