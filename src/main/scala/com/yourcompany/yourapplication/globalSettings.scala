package com.yourcompany.yourapplication

import com.huemulsolutions.bigdata.common._
import scala.collection.mutable.ArrayBuffer 

/**
 * Configuración del ambiente
 */
object globalSettings {
   val Global: huemul_GlobalPath  = new huemul_GlobalPath()
   Global.GlobalEnvironments = "production, experimental"
   
   Global.CONTROL_Setting.append(new huemul_KeyValuePath("production","jdbc:postgresql://{{000.000.000.000}}:5432/{{database_name}}?user={{user_name}}&password={{password}}&currentSchema=public"))
   Global.CONTROL_Setting.append(new huemul_KeyValuePath("experimental","jdbc:postgresql://{{000.000.000.000}}:5432/{{database_name}}?user={{user_name}}&password={{password}}&currentSchema=public"))
  
   Global.ImpalaEnabled = false
   Global.IMPALA_Setting.append(new huemul_KeyValuePath("production","jdbc:impala://{{000.000.000.000}}:21050/default"))
   Global.IMPALA_Setting.append(new huemul_KeyValuePath("experimental","jdbc:impala://{{000.000.000.000}}:21050/default"))
   
   /**
    *NEW FROM 2.3 
    */
   
   //Agregar variable con opciones de conexió JDBC para HIVE
   val HIVE_Setting = new ArrayBuffer[huemul_KeyValuePath]()
   HIVE_Setting.append(new huemul_KeyValuePath("production",s"jdbc:hive2://{{server}}:10000/default;user={{user}};password={{pass}}"))
   HIVE_Setting.append(new huemul_KeyValuePath("experimental",s"jdbc:hive2://{{server}}:10000/default;user={{user}};password={{pass}}"))

   //Para indicar el uso adicional de HIVE mediante JDBC para crear la metadata.
   Global.externalBBDD_conf.Using_HIVE.setActive(true).setActiveForHBASE(true).setConnectionStrings(HIVE_Setting)
   
   /**
    *NEW FROM 2.1 
    */
   
   Global.HIVE_HourToUpdateMetadata = 2 //Numero de horas para guardar cache de metadata de hive, disminuye tiempo de respuesta en 1 minuto aproximadamente, dependiendo del tamaño del cluster.
   
   /**
    *NEW FROM 2.0 
    */
   
   //BACKUP
   Global.MDM_SaveBackup = true
   Global.MDM_Backup_Path.append(new huemul_KeyValuePath("production","hdfs:///user/data/production/backup/"))
   Global.MDM_Backup_Path.append(new huemul_KeyValuePath("experimental","hdfs://hdfs:///user/data/experimental/backup/"))
      
   //DATA QUALITY PATH & DATABASE
   Global.DQ_SaveErrorDetails = true
   Global.DQError_DataBase.append(new huemul_KeyValuePath("production","production_master"))   
   Global.DQError_DataBase.append(new huemul_KeyValuePath("experimental","experimental_master"))
   
   Global.DQError_Path.append(new huemul_KeyValuePath("production","hdfs:///user/data/production/dq/"))
   Global.DQError_Path.append(new huemul_KeyValuePath("experimental","hdfs://hdfs:///user/data/experimental/dq/"))
   
   //MDM OLD VALUE TRACE PATH & DATABASE
   Global.MDM_SaveOldValueTrace = true
   Global.MDM_OldValueTrace_DataBase.append(new huemul_KeyValuePath("production","production_oldvalue"))   
   Global.MDM_OldValueTrace_DataBase.append(new huemul_KeyValuePath("experimental","experimental_oldvalue"))
   
   Global.MDM_OldValueTrace_Path.append(new huemul_KeyValuePath("production","hdfs:///user/data/production/oldvalue/"))
   Global.MDM_OldValueTrace_Path.append(new huemul_KeyValuePath("experimental","hdfs://hdfs:///user/data/experimental/oldvalue/"))
   
   /**
    *FROM 1.0 
    */
   //TEMPORAL SETTING
   Global.TEMPORAL_Path.append(new huemul_KeyValuePath("production","hdfs:///user/data/production/temp/"))
   Global.TEMPORAL_Path.append(new huemul_KeyValuePath("experimental","hdfs://hdfs:///user/data/experimental/temp/"))
     
   //RAW SETTING
   Global.RAW_SmallFiles_Path.append(new huemul_KeyValuePath("production","hdfs:///user/data/production/raw/"))
   Global.RAW_SmallFiles_Path.append(new huemul_KeyValuePath("experimental","hdfs:///user/data/experimental/raw/"))
   
   Global.RAW_BigFiles_Path.append(new huemul_KeyValuePath("production","hdfs:///user/data/production/raw/"))
   Global.RAW_BigFiles_Path.append(new huemul_KeyValuePath("experimental","hdfs:///user/data/experimental/raw/"))
   
   
   
   //MASTER SETTING
   Global.MASTER_DataBase.append(new huemul_KeyValuePath("production","production_master"))   
   Global.MASTER_DataBase.append(new huemul_KeyValuePath("experimental","experimental_master"))

   Global.MASTER_SmallFiles_Path.append(new huemul_KeyValuePath("production","hdfs:///user/data/production/master/"))
   Global.MASTER_SmallFiles_Path.append(new huemul_KeyValuePath("experimental","hdfs:///user/data/experimental/master/"))
   
   Global.MASTER_BigFiles_Path.append(new huemul_KeyValuePath("production","hdfs:///user/data/production/master/"))
   Global.MASTER_BigFiles_Path.append(new huemul_KeyValuePath("experimental","hdfs:///user/data/experimental/master/"))

   //DIM SETTING
   Global.DIM_DataBase.append(new huemul_KeyValuePath("production","production_dim"))   
   Global.DIM_DataBase.append(new huemul_KeyValuePath("experimental","experimental_dim"))

   Global.DIM_SmallFiles_Path.append(new huemul_KeyValuePath("production","hdfs:///user/data/production/dim/"))
   Global.DIM_SmallFiles_Path.append(new huemul_KeyValuePath("experimental","hdfs:///user/data/experimental/dim/"))
   
   Global.DIM_BigFiles_Path.append(new huemul_KeyValuePath("production","hdfs:///user/data/production/dim/"))
   Global.DIM_BigFiles_Path.append(new huemul_KeyValuePath("experimental","hdfs:///user/data/experimental/dim/"))

   //ANALYTICS SETTING
   Global.ANALYTICS_DataBase.append(new huemul_KeyValuePath("production","production_analytics"))   
   Global.ANALYTICS_DataBase.append(new huemul_KeyValuePath("experimental","experimental_analytics"))
   
   Global.ANALYTICS_SmallFiles_Path.append(new huemul_KeyValuePath("production","hdfs:///user/data/production/analytics/"))
   Global.ANALYTICS_SmallFiles_Path.append(new huemul_KeyValuePath("experimental","hdfs:///user/data/experimental/analytics/"))
   
   Global.ANALYTICS_BigFiles_Path.append(new huemul_KeyValuePath("production","hdfs:///user/data/production/analytics/"))
   Global.ANALYTICS_BigFiles_Path.append(new huemul_KeyValuePath("experimental","hdfs:///user/data/experimental/analytics/"))

   //REPORTING SETTING
   Global.REPORTING_DataBase.append(new huemul_KeyValuePath("production","production_reporting"))
   Global.REPORTING_DataBase.append(new huemul_KeyValuePath("experimental","experimental_reporting"))

   Global.REPORTING_SmallFiles_Path.append(new huemul_KeyValuePath("production","hdfs:///user/data/production/reporting/"))
   Global.REPORTING_SmallFiles_Path.append(new huemul_KeyValuePath("experimental","hdfs:///user/data/experimental/reporting/"))
   
   Global.REPORTING_BigFiles_Path.append(new huemul_KeyValuePath("production","hdfs:///user/data/production/reporting/"))
   Global.REPORTING_BigFiles_Path.append(new huemul_KeyValuePath("experimental","hdfs:///user/data/experimental/reporting/"))

   //SANDBOX SETTING
   Global.SANDBOX_DataBase.append(new huemul_KeyValuePath("production","production_sandbox"))
   Global.SANDBOX_DataBase.append(new huemul_KeyValuePath("experimental","experimental_sandbox"))
   
   Global.SANDBOX_SmallFiles_Path.append(new huemul_KeyValuePath("production","hdfs:///user/data/production/sandbox/"))
   Global.SANDBOX_SmallFiles_Path.append(new huemul_KeyValuePath("experimental","hdfs:///user/data/experimental/sandbox/"))
   
   Global.SANDBOX_BigFiles_Path.append(new huemul_KeyValuePath("production","hdfs:///user/data/production/sandbox/"))
   Global.SANDBOX_BigFiles_Path.append(new huemul_KeyValuePath("experimental","hdfs:///user/data/experimental/sandbox/"))

   
}

