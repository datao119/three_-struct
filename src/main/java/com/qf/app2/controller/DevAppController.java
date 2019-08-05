package com.qf.app2.controller;

import com.qf.app2.enums.AppTypeCodeEnum;
import com.qf.app2.pojo.DataDictionary;
import com.qf.app2.service.AppInfoService;
import com.qf.app2.service.DataDirectionaryService;
import com.qf.app2.util.ResultVOUtil;
import com.qf.app2.vo.AppDownloadsVO;
import com.qf.app2.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.qf.app2.constant.AppConstant.DEV_APP_INDEX;
import static com.qf.app2.constant.AppConstant.DEV_APP_MAINTAIN;

/**
 * 项目日期：2019-08-03-8:49 AM
 * 简单描述：
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
@RequestMapping("/dev/app")
@Controller
public class DevAppController{
    @Autowired
    private AppInfoService appInfoService;
    @Autowired
    private DataDirectionaryService dataDirectionaryService;

    //开发者APP首页
    @GetMapping("/index")
    public String index(){
        return DEV_APP_INDEX;
    }
    //查询APP的下载量 TOP FIVE
    @GetMapping("/app-download-top-five")
    @ResponseBody
    public ResultVO appDonwloadTopFive(){
        //1. 调用service查询APP下载量的TOP Five
        List<AppDownloadsVO> data = appInfoService.findAppDownloadTopFive();
        //2. 响应json
        return ResultVOUtil.success(data);
    }

    // 跳转到APP维护页面
    @GetMapping("/app-maintain")
    public String appMaintain(Model model){
        // 1. 查询所属平台.
        List<DataDictionary> flatFormList = dataDirectionaryService.findByTypeCode(AppTypeCodeEnum.APP_FLATFORM.getTypeCode());
        model.addAttribute("flatFormList",flatFormList);
        // 2. APP的状态

        // 3. 查询一级分类.

        return DEV_APP_MAINTAIN;
    }

}
