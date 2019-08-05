package com.qf.app2.service.impl;

import com.qf.app2.mapper.AppInfoMapper;
import com.qf.app2.pojo.AppInfo;
import com.qf.app2.service.AppInfoService;
import com.qf.app2.vo.AppDownloadsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目日期：2019-08-02-10:52 PM
 * 简单描述：
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
@Service
public class AppInfoServiceImpl implements AppInfoService{
    @Autowired
    private AppInfoMapper appInfoMapper;
    @Override
    public List<AppDownloadsVO> findAppDownloadTopFive() {
        //1. 调用mapper查询数据AppInfo
        List<AppInfo> appInfoList = appInfoMapper.findSoftwareNameAndDownsTopFive();
        //2. 将数据封装到List<AppDownloadsVO>
        List<AppDownloadsVO> data = new ArrayList<>();
        for (AppInfo appInfo : appInfoList) {
            AppDownloadsVO vo = new AppDownloadsVO(appInfo.getSoftwareName(),appInfo.getDownloads());
            data.add(vo);
        }
        //3. 返回.
        return data;
    }
}
