package com.example.BookWin.dto.ResponseDto;

import com.example.BookWin.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CenterResponceDto {
    String name;
    String location;
    CenterType type;
}
