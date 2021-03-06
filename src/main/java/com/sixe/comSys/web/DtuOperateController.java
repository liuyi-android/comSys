package com.sixe.comSys.web;


import com.sixe.comSys.base.Contants;
import com.sixe.comSys.base.SpringContextHolder;
import com.sixe.comSys.service.DtuUpdateService;
import com.sixe.comSys.utils.Tools;
import com.sun.istack.internal.logging.Logger;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * dtu修改操作
 * Created by wuqiang on 2017/3/30-0030.
 */
@Controller
@RequestMapping(value = "/dtuOperate")
public class DtuOperateController {

    private static final Logger logger = Logger.getLogger(DtuOperateController.class);

    @Autowired
    private DtuUpdateService dtuUpdateService;
    /**
     * 修改DTUinfo
     * @param dtu_sn
     * @param dtu_name
     * @param dtu_describ
     * @param dtu_address
     * @param dtu_long
     * @param dtu_lat
     * @param dtu_comm_type
     * @param dtu_upfreq
     * @param dtu_warning_type
     * @param dtu_sim_no
     * @param dtu_type
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updDtuInfo.adv")
    public String updDtuInfo(String dtu_sn,String dtu_name,String dtu_describ,String  dtu_address,String dtu_long,
                            String dtu_lat,String dtu_comm_type,String dtu_upfreq,String dtu_warning_type,String dtu_sim_no,String dtu_type){
        logger.info("修改dtuInfo【dtu_sn】"+dtu_sn);
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",dtu_sn);
        map.put("dtu_name",dtu_name);
        map.put("dtu_describ",dtu_describ);
        map.put("dtu_address",dtu_address);
        map.put("dtu_long",dtu_long);
        map.put("dtu_lat",dtu_lat);
        map.put("dtu_comm_type",dtu_comm_type);
        map.put("dtu_upfreq",dtu_upfreq);
        map.put("dtu_warning_type",dtu_warning_type);
        map.put("dtu_sim_no",dtu_sim_no);
        map.put("dtu_type",dtu_type);
        String result= dtuUpdateService.updDtuInfo(map);
        logger.info("修改dtuInfo【result】"+result);
        return Tools.sendJson(result);
    }

    /**
     * 标记报警信息为已处理
     * @param dtu_sn
     * @param msgid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updWarningMsg")
    public String updWarningMsg(String dtu_sn,String msgid){
        logger.info("标记报警信息为已处理：【dtu_sn】"+dtu_sn);
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",dtu_sn);
        map.put("msgid",msgid);
        String result = dtuUpdateService.update(map,Contants.DEAL_DTU_SENSOR_WARNING_MSG);
        return Tools.sendJson(result);
    }

    /**
     * 删除分组信息
     * @param nodeId
     * @param groupId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delGroup.adv")
    public String delGroup(String nodeId,String groupId){
        logger.info("删除【nodeId】:"+nodeId+",【groupId】:"+groupId);
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        map.put("group_id",groupId);
        String result = dtuUpdateService.update(map,Contants.DEL_DTU_GROUP_INFO);
        return Tools.sendJson(result);
    }

    /**
     * 新增分组数据
     * @param nodeId
     * @param aname1
     * @param asj1
     * @param asj2
     * @param asj3
     * @param asj4
     * @param asj5
     * @param asj6
     * @param asj7
     * @param asj8
     * @param asj9
     * @param asj10
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addGroup.adv")
    public String addGroup(String nodeId,String aname1,String asj1,String asj2,String asj3,String asj4,String asj5,String asj6,String asj7,String asj8,String asj9,String asj10){
        String [] arr = { asj1, asj2, asj3, asj4, asj5, asj6, asj7, asj8, asj9, asj10};
        System.out.println("asj:"+arr.toString());
        int i = 10 ;
        for (String s:arr){
            if("0".equals(s)){
                i--;
            }
        }
        logger.info("【新增】：");
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        map.put("group_describ",aname1);
        map.put("group_datanum",String.valueOf(i));
        map.put("group_datano1",asj1);
        map.put("group_datano2",asj2);
        map.put("group_datano3",asj3);
        map.put("group_datano4",asj4);
        map.put("group_datano5",asj5);
        map.put("group_datano6",asj6);
        map.put("group_datano7",asj7);
        map.put("group_datano8",asj8);
        map.put("group_datano9",asj9);
        map.put("group_datano10",asj10);
        String result = dtuUpdateService.update(map,Contants.ADD_DTU_GROUP_INFO);
        return Tools.sendJson(result);
    }

    /**
     * 修改dtu分组信息
     * @param nodeId
     * @param groupId
     * @param aname1
     * @param asj1
     * @param asj2
     * @param asj3
     * @param asj4
     * @param asj5
     * @param asj6
     * @param asj7
     * @param asj8
     * @param asj9
     * @param asj10
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updGroup.adv")
    public String updGroup(String nodeId,String groupId,String aname1,String asj1,String asj2,String asj3,String asj4,String asj5,String asj6,String asj7,String asj8,String asj9,String asj10){
        String [] arr = { asj1, asj2, asj3, asj4, asj5, asj6, asj7, asj8, asj9, asj10};
        System.out.println("asj:"+arr.toString());
        int i = 10 ;
        for (String s:arr){
            if("0".equals(s)){
                i--;
            }
        }
        logger.info("【修改】：");
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        map.put("group_describ",aname1);
        map.put("group_id",groupId);
        map.put("group_datanum",String.valueOf(i));
        map.put("group_datano1",asj1);
        map.put("group_datano2",asj2);
        map.put("group_datano3",asj3);
        map.put("group_datano4",asj4);
        map.put("group_datano5",asj5);
        map.put("group_datano6",asj6);
        map.put("group_datano7",asj7);
        map.put("group_datano8",asj8);
        map.put("group_datano9",asj9);
        map.put("group_datano10",asj10);
        String result = dtuUpdateService.update(map,Contants.UPDATE_DTU_GROUP_INFO);
        return Tools.sendJson(result);
    }

    /**
     * 修改报警信息
     * @param nodeId
     * @param uname
     * @param udescrib
     * @param udata_no
     * @param uup
     * @param ulow
     * @param ulasting
     * @param uinterval
     * @param uenable
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updSensorWarningInfo.adv")
    public String updSensorWarningInfo(String nodeId,String uname,String udescrib,String udata_no,String uup,
                                       String ulow,String ulasting,String uinterval,String uenable){
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        map.put("data_no",udata_no);
        map.put("warn_up",uup);
        map.put("warn_low",ulow);
        map.put("warn_lasting",ulasting);
        map.put("warn_interval",uinterval);
        map.put("warn_enable",uenable);
        String result = dtuUpdateService.update(map,Contants.UPDATE_DTU_SENSOR_WARNING_INFO);
        return Tools.sendJson(result);
    }

    @ResponseBody
    @RequestMapping(value = "/updDtuTaskInfo.adv")
    public String updDtuTaskInfo(String nodeId ,String uchannel,String utype,String udt,String utm,String uecond
                                        ,String nodeAddr){
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        map.put("node_addr",nodeAddr);
        map.put("tsk_num","8");
        map.put("tsk_current_channel",uchannel);
        map.put("tsk_type",utype);
        map.put("tsk_dt",udt);
        map.put("tsk_tm",utm);

        map.put("tsk_second",uecond);
        map.put("op_user", SpringContextHolder.getCurrentUser().getResult().getUser_id());
        String result = dtuUpdateService.update(map,Contants.UPDATE_DTU_CTRL_NODE_TASK);
        return Tools.sendJson(result);
    }

    /**
     * 修改控制节点信息
     * @param dtu_sn
     * @param uname
     * @param ucfg
     * @param uaddr
     * @param size
     * @param node_no
     * @param udescrib
     * @param ux
     * @param uy
     * @param utsknum
     * @param tsk1
     * @param tsk2
     * @param tsk3
     * @param tsk4
     * @param tsk5
     * @param tsk6
     * @param tsk7
     * @param tsk8
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/udpDtuControlNodeInfo.adv", method = RequestMethod.POST)
    public String udpDtuControlNodeInfo(String dtu_sn,String uname,String ucfg,String uaddr,String size,String node_no,String udescrib,String ux,String uy,String utsknum,
                                        String tsk1,String tsk2,String tsk3,String tsk4,String tsk5,String tsk6,String tsk7,String tsk8){
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",dtu_sn);
        map.put("node_num",size);
        map.put("node_no",node_no);
        map.put("node_cfg",ucfg.replace(".0","").trim());
        map.put("node_addr",uaddr);
        map.put("node_describ",udescrib);
        map.put("node_screen_x",ux);
        map.put("node_screen_y",uy);
        int i = 0;
        if(tsk1 != null & tsk1 !=""){
            i++;
            map.put("ctrl_ch_describ_1",tsk1);
        }
        if(tsk2 != null & tsk2 !="") {
            i++;
            map.put("ctrl_ch_describ_2",tsk2);
        }
        if(tsk3 != null & tsk3 !="") {
            i++;
            map.put("ctrl_ch_describ_3",tsk3);
        }
        if(tsk4 != null & tsk4 !="") {
            i++;
            map.put("ctrl_ch_describ_4",tsk4);
        }
        if(tsk5 != null & tsk5 !="") {
            i++;
            map.put("ctrl_ch_describ_5", tsk5);
        }
        if(tsk6 != null & tsk6 !="") {
            i++;
            map.put("ctrl_ch_describ_6",tsk6);
        }
        if(tsk7 != null & tsk7 != ""){
            i++;
            map.put("ctrl_ch_describ_7",tsk7);
        }
        if(tsk8 != null & tsk8 != ""){
            i++;
            map.put("ctrl_ch_describ_8",tsk8);
        }
        map.put("ctrl_ch_num",i+"");
        System.out.println("请求参数："+map.toString());
        String result = dtuUpdateService.update(map,Contants.UPDATE_DTU_CTRL_NODE_INFO);
        return Tools.sendJson(result);
    }

    /**
     * 新增控制节点信息
     * @param dtu_sn
     * @param uname
     * @param ucfg
     * @param aaddr
     * @param size
     * @param udescrib
     * @param ux
     * @param uy
     * @param utsknum
     * @param tsk1
     * @param tsk2
     * @param tsk3
     * @param tsk4
     * @param tsk5
     * @param tsk6
     * @param tsk7
     * @param tsk8
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addDtuControlNodeInfo.adv", method = RequestMethod.POST)
    public String addDtuControlNodeInfo(String dtu_sn,String uname,String ucfg,String aaddr,String size,String udescrib,String ux,String uy,String utsknum,
                                        String tsk1,String tsk2,String tsk3,String tsk4,String tsk5,String tsk6,String tsk7,String tsk8){
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",dtu_sn);
        map.put("node_num",(Integer.parseInt(size)+1)+"");
        map.put("node_no",(Integer.parseInt(size)+1)+"");
        map.put("node_cfg",ucfg.replace(".0","").trim());
        map.put("node_addr",aaddr);
        map.put("node_describ",udescrib);
        map.put("node_screen_x",ux);
        map.put("node_screen_y",uy);
        int i = 0;
        if(tsk1 != null & tsk1 !=""){
            i++;
            map.put("ctrl_ch_describ_1",tsk1);
        }
        if(tsk2 != null & tsk2 !="") {
            i++;
            map.put("ctrl_ch_describ_2",tsk2);
        }
        if(tsk3 != null & tsk3 !="") {
            i++;
            map.put("ctrl_ch_describ_3",tsk3);
        }
        if(tsk4 != null & tsk4 !="") {
            i++;
            map.put("ctrl_ch_describ_4",tsk4);
        }
        if(tsk5 != null & tsk5 !="") {
            i++;
            map.put("ctrl_ch_describ_5", tsk5);
        }
        if(tsk6 != null & tsk6 !="") {
            i++;
            map.put("ctrl_ch_describ_6",tsk6);
        }
        if(tsk7 != null & tsk7 != ""){
            i++;
            map.put("ctrl_ch_describ_7",tsk7);
        }
        if(tsk8 != null & tsk8 != ""){
            i++;
            map.put("ctrl_ch_describ_8",tsk8);
        }
        map.put("ctrl_ch_num",i+"");
        System.out.println("请求参数："+map.toString());
        String result = dtuUpdateService.update(map,Contants.UPDATE_DTU_CTRL_NODE_INFO);
        return Tools.sendJson(result);
    }

    /**
     * 同步控制节点信息
     * @param nodeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/synControlNodeInfo.adv", method = RequestMethod.POST)
    public String synControlNodeInfo(String nodeId){
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        String result = dtuUpdateService.update(map,Contants.SYNC_DTU_CTRL_NODE_INFO);
        return Tools.sendJson(result);
    }

    /**
     * 新增传感器节点
     * @param dtu_sn
     * @param ucfg
     * @param aaddr
     * @param size
     * @param udescrib
     * @param ux
     * @param uy
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addDtuSensorNodeInfo.adv", method = RequestMethod.POST)
    public String addDtuSensorNodeInfo(String dtu_sn,String ucfg,String aaddr,String size,String udescrib,String ux,String uy){
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",dtu_sn);
        map.put("node_num",(Integer.parseInt(size)+1)+"");
        map.put("node_no",(Integer.parseInt(size)+1)+"");
        map.put("node_cfg",ucfg.replace(".0","").trim());
        map.put("node_addr",aaddr);
        map.put("node_describ",udescrib);
        map.put("node_screen_x",ux);
        map.put("node_screen_y",uy);
        System.out.println("【新增传感器信息】请求参数："+map.toString());
        String result = dtuUpdateService.update(map,Contants.UPDATE_DTU_SENSOR_NODE_INFO);
        return Tools.sendJson(result);
    }

    /**
     * 修改传感器信息
     * @param dtu_sn
     * @param ucfg
     * @param node_no
     * @param aaddr
     * @param size
     * @param udescrib
     * @param ux
     * @param uy
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updDtuSensorNodeInfo.adv", method = RequestMethod.POST)
    public String updDtuSensorNodeInfo(String dtu_sn,String ucfg,String node_no,String aaddr,String size,String udescrib,String ux,String uy){
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",dtu_sn);
        map.put("node_num",size);
        map.put("node_cfg",ucfg.replace(".0","").trim());
        map.put("node_addr",aaddr);
        map.put("node_describ",udescrib);
        map.put("node_screen_x",ux);
        map.put("node_screen_y",uy);
        map.put("node_no",node_no);
        System.out.println("【修改传感器信息】请求参数："+map.toString());
        String result = dtuUpdateService.update(map,Contants.UPDATE_DTU_SENSOR_NODE_INFO);
        return Tools.sendJson(result);
    }

    /**
     * 删除控制节点
     * @param nodeId
     * @param nodeAddr
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delCtrlNodeInfo.adv", method = RequestMethod.POST)
    public String delCtrlNodeInfo(String nodeId,String nodeAddr){
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        map.put("node_addr",nodeAddr);
        String result = dtuUpdateService.update(map,Contants.DEL_DTU_CTRL_NODE_INFO);
        return Tools.sendJson(result);
    }

    /**
     * 删除传感器节点
     * @param nodeId
     * @param nodeAddr
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delSensorNodeInfo.adv", method = RequestMethod.POST)
    public String delSensorNodeInfo(String nodeId,String nodeAddr){
            Map<String,String> map = new HashedMap();
            map.put("dtu_sn",nodeId);
            map.put("node_addr",nodeAddr);
            String result = dtuUpdateService.update(map,Contants.DEL_DTU_SENSOR_NODE_INFO);
            return Tools.sendJson(result);
    }

    /**
     * 同步传感器节点信息
     * @param nodeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/synSensorNodeInfo.adv", method = RequestMethod.POST)
    public String synSensorNodeInfo(String nodeId){
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        String result = dtuUpdateService.update(map,Contants.SYNC_DTU_SENSOR_NODE_INFO);
        return Tools.sendJson(result);
    }

}
