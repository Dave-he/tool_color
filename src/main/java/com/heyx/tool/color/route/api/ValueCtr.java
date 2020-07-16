package com.heyx.tool.color.route.api;

import com.heyx.tool.color.common.constant.SystemConst;
import com.heyx.tool.color.common.system.ColorUtils;
import com.heyx.tool.color.common.system.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author heyx
 * @date 7/16/2020 5:06 PM
 */

@RestController
@RequestMapping(SystemConst.PC + "/value")
@Api(tags = SystemConst.PC_TAG +"色值查询")
public class ValueCtr {

    @GetMapping("/all")
    @ApiOperation(value = "查询全部色值")
    public ResponseUtils all(
            @RequestParam(name = "r", defaultValue = "256", required = false) Integer r,
            @RequestParam(name = "g", defaultValue = "256", required = false) Integer g,
            @RequestParam(name = "b", defaultValue = "256", required = false) Integer b
    ) {
        return ResponseUtils.getSuccessResponseJoData(ColorUtils.getAllColor(r, g, b));
    }
    @GetMapping("/random")
    @ApiOperation(value = "查询随机色值")
    public ResponseUtils random(
            @RequestParam(name = "max", defaultValue = "1", required = false) Integer max
    ) {
        return ResponseUtils.getSuccessResponseJoData(ColorUtils.getRandomColorList(max));
    }
}
